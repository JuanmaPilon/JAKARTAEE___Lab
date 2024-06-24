package ModuloPeaje.remota;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import org.tallerjava.DatosPagoDTO;
import org.tallerjava.IdentificadorDTO;

// curl -X GET -v http://localhost:8080/Sistema-Gestion/rest/autorizar -H "Content-Type: application/json" -d '{"tag":11111,"matricula":"BAA 1234"}'
@ApplicationScoped
@Path("/Peaje")
public class PeajeAPI {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private ModuloPeajeImpl moduloPeaje;


    @GET //tal vez POST sea una mejor alternativa
    @Path("/Autorizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean autorizarVehiculo(IdentificadorDTO idDTO) {

        boolean autorizado =
                moduloPeaje.estaHabilitado(idDTO.getTag(), idDTO.getMatricula());

        log.infof("Autorizando vehiculo %d, resultado %b", idDTO, autorizado);
        return autorizado;
    }
    @GET
    @Path("/contarVehiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response contarVehiculo(IdentificadorDTO idDTO) {
        moduloPeaje.estaHabilitado(idDTO.getTag(), idDTO.getMatricula());
        log.infof("Contando Vehiculos " + idDTO);
        return Response.ok("Conto un vehiculo").status(200,"OK").build();
    }

}
