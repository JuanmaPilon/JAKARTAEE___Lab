package ModuloMediosPago.Interface.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import java.util.List;

import ModuloMediosPago.Aplicacion.*;
import ModuloMediosPago.Dominio.*;

@ApplicationScoped
public class IMediosPago {

    @Inject
    private ModuloMediosPagoAplicacion firma;

    private static final Logger log = Logger.getLogger(IMediosPago.class);
    @PUT
    @Path("/clientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void nuevoCliente(ClienteTelepeaje cli, Tarjeta tarjeta) {
        log.debugf("Alta cliente: %s", cli.toString(), tarjeta.toString());
        firma.altaCliente(cli, tarjeta);
    }
}
