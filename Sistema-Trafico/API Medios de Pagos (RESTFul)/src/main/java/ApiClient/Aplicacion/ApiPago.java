package ApiClient.Aplicacion;

import jakarta.ws.rs.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import ApiClient.Aplicacion.IApiPago;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/mensaje")
public class ApiPago {

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response mensaje() {
        System.out.println("Todo ok negro");
        return Response.ok("Tdo ok").status(200, "OK").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUsuarioDTO() {
        System.out.println("Todo ok negro");
//        usuarioDTO = new UsuarioDTO();

        return Response.ok("Funciona ok").status(200, "Nice").build();
    }


}