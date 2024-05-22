package ApiClient.Aplicacion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import ApiClient.Dominio.*;


@ApplicationScoped

public class ApiPago {

    @Inject
//    private Usuario usuario;

//    @GET
//    @Path("/nombre")
//    public Response getNombre(@QueryParam("ci") String ci ) {
//        String data = usuario.getNom();
//        return Response.ok(data).build();
//    }

    @GET
    @Path("/nombre")
    public Response getNombre() {
        return Response.ok("Todo OK").build();
    }

//    @GET
//    @Path("/pagos/{id}")
//    public Response getPagoById(@PathParam("id") String id) {
//        String data = ApiPago.getPagoById(id);
//        return Response.ok(data).build();
//    }
}