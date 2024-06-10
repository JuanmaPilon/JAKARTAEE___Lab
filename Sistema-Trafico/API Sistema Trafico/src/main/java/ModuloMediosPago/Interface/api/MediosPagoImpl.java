package ModuloMediosPago.Interface.api;
import ModuloMediosPago.Dominio.ClienteTelepeaje;
import ModuloMediosPago.Dominio.Tarjeta;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.inject.Inject;
import org.tallerjava.ClienteTelepeajeDTO;
import org.tallerjava.TarjetaDTO;
import ModuloMediosPago.Aplicacion.ModuloMediosPagoAplicacion;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import org.jboss.logging.Logger;
import java.util.ArrayList;
@ApplicationScoped
@ApplicationPath("/medios-pago")
public class MediosPagoImpl implements IMediosPago{

    @Inject
    private ModuloMediosPagoAplicacion firma;

    private static final Logger log = Logger.getLogger(MediosPagoImpl.class);

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public void CobroTelepeaje(ClienteTelepeajeDTO clienteDTO, TarjetaDTO tarjetaDTO) {

        try {
            // Convertir los DTOs a JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String clienteJson = objectMapper.writeValueAsString(clienteDTO);
            String tarjetaJson = objectMapper.writeValueAsString(tarjetaDTO);

            // Crear el cuerpo de la solicitud
            String requestBody = String.format("{\"cliente\": %s, \"tarjeta\": %s}", clienteJson, tarjetaJson);

            // Crear la solicitud HTTP POST
            String apiEndpoint = "http://127.0.0.1:8080/Medios-de-Pago/api/mensaje";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiEndpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Enviar la solicitud de manera asíncrona
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
        } catch (Exception e) {
            log.error("Exception during request preparation", e);
        }
    }
}