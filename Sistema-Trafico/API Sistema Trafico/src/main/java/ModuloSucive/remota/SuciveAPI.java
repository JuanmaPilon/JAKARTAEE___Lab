package ModuloSucive.remota;
import ModuloSucive.Aplicacion.ModuloSucive;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import org.tallerjava.PagoDTO;

@ApplicationScoped
@Path("/Pago-Sucive")
public class SuciveAPI {

    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private ModuloSucive moduloSucive;


    @GET //tal vez POST sea una mejor alternativa
    @Consumes(MediaType.APPLICATION_JSON)
    public void pagoSucive(PagoDTO idDTO) {


        moduloSucive.notificarPago(idDTO.getMatricula(), idDTO.getImporte());

        log.infof("Notificando PagoSucive " + idDTO);

    }
}
