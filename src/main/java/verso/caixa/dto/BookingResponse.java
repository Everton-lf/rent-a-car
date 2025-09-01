package verso.caixa.dto;


import verso.caixa.domain.Booking;

import java.time.LocalDate;

public class BookingResponse {
    public Long id;
    public Long vehicleId;
    public LocalDate startDate;
    public LocalDate endDate;
    public Long customerId;

    public static BookingResponse from(Booking b) {
        var r = new BookingResponse();
        r.id = b.id;
        r.vehicleId = b.vehicleId;
        r.startDate = b.startDate;
        r.endDate = b.endDate;
        r.customerId = b.customerId;
        return r;
    }
}