package verso.caixa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import verso.caixa.domain.Booking;
import verso.caixa.domain.BookingRepository;
import verso.caixa.dto.BookingRequest;


import java.util.List;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository repo;

    public Booking create(BookingRequest req, Long customerId) {
        Booking b = new Booking();
        b.vehicleId = req.vehicleId;
        b.startDate = req.startDate;
        b.endDate = req.endDate;
        b.customerId = customerId;
        repo.persist(b);
        return b;
    }

    public List<Booking> listAll() {
        return repo.listAll();
    }

    public Booking getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
