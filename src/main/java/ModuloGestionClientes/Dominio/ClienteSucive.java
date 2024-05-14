package ModuloGestionClientes.Dominio;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// mismo que las otras clases, tambien hay que quitar las otras viejas desactualizadas de cada modulo y solo ponerlos aca

@Data
public class ClienteSucive {
    private String nombre;
    // no me lo agarra usr nacional si es private, lo cambio a public, pero no se si estara bien
    private String ci;
    private List<Vehiculo> vehiculosCliente;

    public ClienteSucive() {
        this.vehiculosCliente = new ArrayList<>();
    }

    public ClienteSucive(String nombre, String ci, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.vehiculosCliente = vehiculosCliente;
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }

}
