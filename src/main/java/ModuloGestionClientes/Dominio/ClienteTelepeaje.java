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
    private Double saldo;

    public ClienteTelepeaje() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
    }

    public ClienteTelepeaje(String nombre, String ci,String email, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.vehiculosCliente = vehiculosCliente;
        this.saldo = 0.0;
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }

    public void cargarSaldo(Double importe) {
        this.saldo += importe;
    }


}


