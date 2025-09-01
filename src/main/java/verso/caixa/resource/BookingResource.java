package verso.caixa.resource;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import verso.caixa.dto.BookingRequest;
import verso.caixa.dto.BookingResponse;
import verso.caixa.service.BookingService;


import java.util.List;

@Path("/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingService service;

    @Inject
    SecurityIdentity identity;

    @POST
    public Response create(@Valid BookingRequest req) {

        Long customerId = Long.valueOf(identity.getAttribute("customerId"));
        var booking = service.create(req, customerId);
        return Response.ok(BookingResponse.from(booking)).build();
    }

    @GET
    public List<BookingResponse> listAll() {
        return service.listAll().stream().map(BookingResponse::from).toList();
    }

    @GET
    @Path("/{id}")
    public BookingResponse get(@PathParam("id") Long id) {
        return BookingResponse.from(service.getById(id));
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
