package ModuloGestionClientes.remota;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import org.tallerjava.DatosPagoDTO;



@ApplicationScoped
@Path("/Gestion")
public class GestionAPI {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private ModuloGestionClientes moduloGestion;

    @GET
    @Path("/PostPago")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPago(DatosPagoDTO idDTO) {
        moduloGestion.realizarPostPago(idDTO.getTag(), idDTO.getImporte());
        log.infof("Notificando PostPago " + idDTO);
    }
    @GET
    @Path("/PrePago")
    @Consumes(MediaType.APPLICATION_JSON)
    public void prePago(DatosPagoDTO idDTO) {
        moduloGestion.realizarPrePago(idDTO.getTag(), idDTO.getImporte());
        log.infof("Notificando PrePago " + idDTO);
    }
}
