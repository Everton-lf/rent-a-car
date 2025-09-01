package verso.caixa.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Long vehicleId;

    public LocalDate startDate;

    public LocalDate endDate;

    public Long customerId;
}