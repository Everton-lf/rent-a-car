package verso.caixa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import verso.caixa.domain.Vehicle;


    @ApplicationScoped
    public class VehicleRepository implements PanacheRepository<Vehicle> {

    }

