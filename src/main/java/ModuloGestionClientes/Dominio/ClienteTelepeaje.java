package ModuloGestionClientes.Dominio;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
// cambie por data que ya incluye setters , getters, pareses y to string y otras cosas.

@Data
public class ClienteTelepeaje {

    private String nombre;
    private String ci;
    private String email;
    private List<Vehiculo> vehiculosCliente;

    public ClienteTelepeaje() {
        this.vehiculosCliente = new ArrayList<>();
    }

    public ClienteTelepeaje(String nombre, String ci,String email, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.vehiculosCliente = vehiculosCliente;
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }
}


