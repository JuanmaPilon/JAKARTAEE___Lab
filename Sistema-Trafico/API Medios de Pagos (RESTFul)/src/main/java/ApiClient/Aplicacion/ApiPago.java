package ApiClient.Aplicacion;

import jakarta.ws.rs.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import ApiClient.Aplicacion.IApiPago;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.tallerjava.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Response Cobro(String json) {
        try {
            // Deserializar el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            ApiRequestData requestData = objectMapper.readValue(json, ApiRequestData.class);

            // Imprimir los datos
            ClienteTelepeajeDTO cliente = requestData.getCliente();
            TarjetaDTO tarjeta = requestData.getTarjeta();

            System.out.println("Cliente Nombre: " + cliente.getNombre());
            System.out.println("Cliente CI: " + cliente.getCi());
            System.out.println("Cliente Email: " + cliente.getEmail());

            System.out.println("Tarjeta Número: " + tarjeta.getNroTarjeta());
            System.out.println("Tarjeta Nombre: " + tarjeta.getNombre());
            System.out.println("Tarjeta Fecha Vto: " + tarjeta.getFechaVto());

            return Response.ok("Cobro Realizado").status(200, "OK").build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(400, "Error en el formato del JSON").build();
        }
    }

    // Clase interna para deserializar la petición JSON
    public static class ApiRequestData {
        private ClienteTelepeajeDTO cliente;
        private TarjetaDTO tarjeta;

        public ClienteTelepeajeDTO getCliente() {
            return cliente;
        }

        public void setCliente(ClienteTelepeajeDTO cliente) {
            this.cliente = cliente;
        }

        public TarjetaDTO getTarjeta() {
            return tarjeta;
        }

        public void setTarjeta(TarjetaDTO tarjeta) {
            this.tarjeta = tarjeta;
        }
    }

}