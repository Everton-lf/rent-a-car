package verso.caixa.service;




import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import verso.caixa.domain.Vehicle;
import verso.caixa.domain.VehicleStatus;
import verso.caixa.dto.UpdateStatusRequest;
import verso.caixa.dto.VehicleRequest;
import verso.caixa.exception.BusinessException;
import verso.caixa.repository.VehicleRepository;

import java.util.List;

@ApplicationScoped
public class VehicleService {

    @Inject
    VehicleRepository repository;

    @Transactional
    public Vehicle create(VehicleRequest req) {
        Vehicle v = new Vehicle();
        v.brand = req.getBrand();
        v.model = req.getModel();
        v.engine = req.getEngine();
        v.anoFabricacao = req.getAnoFabricacao();
        v.status = VehicleStatus.AVAILABLE;
        repository.persist(v);
        return v;
    }

    public List<Vehicle> listAll() {
        return repository.listAll();
    }

    public Vehicle getById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Vehicle %d not found".formatted(id)));
    }

    @Transactional
    public Vehicle update(Long id, VehicleRequest req) {
        Vehicle v = getById(id);
        v.brand = req.getBrand();
        v.model = req.getModel();
        v.engine = req.getEngine();
        v.anoFabricacao = req.getAnoFabricacao();
        return v;
    }

    @Transactional
    public Vehicle updateStatus(Long id, UpdateStatusRequest req) {
        Vehicle v = getById(id);
        VehicleStatus from = v.status;
        VehicleStatus to = req.status();

        if (!isValidTransition(from, to)) {
            throw new BusinessException("Transição de status inválida: " + from + " -> " + to);
        }

        v.status = to;
        return v;
    }

    @Transactional
    public void delete(Long id) {
        Vehicle v = getById(id);
        if (v.status == VehicleStatus.RENTED) {
            throw new BusinessException("Veículo não pode ser removido quando está Alugado");
        }
        repository.delete(v);
    }

    private boolean isValidTransition(VehicleStatus from, VehicleStatus to) {
        if (to == VehicleStatus.UNDER_MAINTENANCE) return true;
        if (to == VehicleStatus.RENTED) return from == VehicleStatus.AVAILABLE;
        if (to == VehicleStatus.AVAILABLE) return from == VehicleStatus.RENTED || from == VehicleStatus.UNDER_MAINTENANCE;
        return false;
    }
}

