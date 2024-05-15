package ModuloGestionClientes.Dominio;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// mismo que las otras clases, tambien hay que quitar las otras viejas desactualizadas de cada modulo y solo ponerlos aca

@Data
public class ClienteSucive {
    private String nombre;
    // no me lo agarra usr nacional si es private, lo cambio a public, pero no se si estara bien
    private String ci;
    private List<Vehiculo> vehiculosCliente;
    private Double saldo;
    private Tarjeta tarjeta;
    private List<PasadaPorPeaje> pasadaPorPeaje;

    public ClienteSucive() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public ClienteSucive(String nombre, String ci, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.vehiculosCliente = vehiculosCliente;
        this.saldo = 0.0;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }

    public void cargarSaldo(Double importe) {
        this.saldo += importe;
    }

    public Double consultarSaldo() {
        return this.saldo;
    }

    public void asociarTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<PasadaPorPeaje> getPasadasPorPeaje() {
        return this.pasadaPorPeaje;
    }

    public List<PasadaPorPeaje> getPasadasEnRango(Date fechaInicio, Date fechaFin) {
        List<PasadaPorPeaje> pasadasEnRango = new ArrayList<>();
        for (PasadaPorPeaje pasada : this.pasadaPorPeaje) {
            if (!pasada.getFecha().before(fechaInicio) && !pasada.getFecha().after(fechaFin)) {
                pasadasEnRango.add(pasada);
            }
        }
        return pasadasEnRango;
    }

}
