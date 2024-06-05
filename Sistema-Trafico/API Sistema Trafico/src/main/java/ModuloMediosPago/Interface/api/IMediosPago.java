package ModuloMediosPago.Interface.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import ModuloMediosPago.Aplicacion.ModuloMediosPagoAplicacion;
import ModuloMediosPago.Dominio.ClienteTelepeaje;
import ModuloMediosPago.Dominio.Tarjeta;

@ApplicationScoped
@Path("/medios-pago")
public class IMediosPago {

    @Inject
    private ModuloMediosPagoAplicacion firma;

    private static final Logger log = Logger.getLogger(IMediosPago.class);

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @PUT
    @Path("/clientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void nuevoCliente(ClienteTelepeaje cli, Tarjeta tarjeta) {
        log.debugf("Alta cliente: %s", cli.toString(), tarjeta.toString());
        firma.altaCliente(cli, tarjeta);
    }

    @GET
    @Path("/consulta-api")
    @Produces(MediaType.APPLICATION_JSON)
    public void consultaApi() {
        String apiEndpoint = "http://127.0.0.1:8080/Medios-de-Pago/api/mensaje";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiEndpoint))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        responseFuture.thenAccept(response -> {
            if (response.statusCode() == 200) {
                log.debugf("Response: %s", response.body());
            } else {
                log.errorf("Failed with status code: %d", response.statusCode());
            }
        }).exceptionally(e -> {
            log.error("Error during request", e);
            return null;
        });

        log.debug("Request sent, doing other work...");
    }
}

