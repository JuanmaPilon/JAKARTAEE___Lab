package ApiClient.Aplicacion;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

public interface IApiPago {

    @GET
    @Path("/nombre")
    String getNombre();

//    @GET
//    @Path("/pagos/{id}")
//    String getPagoById(@PathParam("id") String id);
}

