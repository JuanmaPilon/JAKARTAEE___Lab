package ModuloGestionClientes.remota;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import ModuloGestionClientes.Dominio.PasadaPorPeaje;
import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloGestionClientes.Dominio.Vehiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import org.tallerjava.DatosConsultaPasadaDTO;
import org.tallerjava.DatosPagoDTO;

import java.util.Set;


@ApplicationScoped
@Path("/Gestion")
public class GestionAPI {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private ModuloGestionClientes moduloGestion;
    @Inject
    private RepoClientes repo;

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
    @GET
    @Path("/ObtenerPasadas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Set<PasadaPorPeaje> ObtenerPasadas(DatosConsultaPasadaDTO dto) {
        ClienteTelepeaje clienteTelepeaje = repo.buscarClienteTelePorCI(dto.getCedula());
        Vehiculo vehiculo = repo.BuscarTag(dto.getTag());
        Set<PasadaPorPeaje> set = moduloGestion.consultarPasadas(clienteTelepeaje,dto.getFechaInicio(),dto.getFechaFin(),vehiculo);
        log.infof("Consultando Pasadas");
        //return Response.ok("Conto un vehiculo").status(200,"OK").build();
        return set;
    }
}
