package ApiClient.Aplicacion;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import okhttp3.Response;

public interface IApiPago {
    public Response mensaje();
    public Response otroMensaje();
}

