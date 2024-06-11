package ModuloPeaje.remota;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.ModuloPeajeAplicacion;
import org.tallerjava.IdentificadorDTO;


@ApplicationScoped
@Path("/autorizar")
public class PeajeAPI {
    private static final Logger log = Logger.getLogger(ModuloPeajeAplicacion.class);

    @Inject
    private ModuloPeajeAplicacion servicioPeaje;

    /**
     * curl -X GET -v http://localhost:8080/06-JakartaProyectoReferencia/trafico/autorizar -H "Content-Type: application/json" -d '{"tag":11111,"matricula":"BAA 1234"}'
     *
     * @param idDTO
     * @return
     */
    @GET //tal vez POST sea una mejor alternativa
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean autorizarVehiculo(IdentificadorDTO idDTO) {

        boolean autorizado =
                servicioPeaje.estaHabilitado(idDTO.getTag(), idDTO.getMatricula());

        log.infof("Autorizando vehiculo %d, resultado %b", idDTO, autorizado);
        return autorizado;
    }
}
