package ApiClient.Aplicacion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import ApiClient.Aplicacion.IApiPago;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.tallerjava.*;


@ApplicationScoped
@Path("/mensaje")
public class ApiPago {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response mensaje() {
        System.out.println("Todo ok negro cagado");
        return Response.ok("Tdo ok").status(200, "OK").build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUsuarioDTO(UsuarioDTO usuarioDTO) {
        System.out.println("Todo ok negro cagado");
        usuarioDTO = new UsuarioDTO();

        return Response.ok("Funciona ok").status(200, "Nice").build();
    }


}