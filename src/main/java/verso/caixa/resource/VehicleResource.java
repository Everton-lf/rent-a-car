package verso.caixa.resource;



import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import verso.caixa.dto.UpdateStatusRequest;
import verso.caixa.dto.VehicleRequest;
import verso.caixa.dto.VehicleResponse;
import verso.caixa.service.VehicleService;

import java.net.URI;
import java.util.List;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleService service;

    @POST
    @Path("/vehicles")
    public Response create(@Valid VehicleRequest req) {
        var v = service.create(req);
        return Response.created(URI.create("/vehicles/" + v.id))
                .entity(VehicleResponse.from(v))
                .build();
    }

    @GET
    public List<VehicleResponse> listAll() {
        return service.listAll().stream().map(VehicleResponse::from).toList();
    }

    @GET
    @Path("/{id}")
    public VehicleResponse get(@PathParam("id") Long id) {
        return VehicleResponse.from(service.getById(id));
    }

    @PUT
    @Path("/{id}")
    public VehicleResponse update(@PathParam("id") Long id, @Valid VehicleRequest req) {
        return VehicleResponse.from(service.update(id, req));
    }

    @PATCH
    @Path("/{id}/status")
    public VehicleResponse updateStatus(@PathParam("id") Long id, @Valid UpdateStatusRequest req) {
        return VehicleResponse.from(service.updateStatus(id, req));
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
