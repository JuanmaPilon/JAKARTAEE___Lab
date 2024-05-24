package ModuloGestionClientes.Dominio;

import lombok.Data;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// mismo que las otras clases, también hay que quitar las otras viejas desactualizadas de cada modulo y solo ponerlos aca

@Data
@Entity
@Table(name = "gestion_clienteSucive")
public class ClienteSucive {

    // no me lo agarra usr nacional si es private, lo cambio a public, pero no se si estará bien
    @Id
    private String ci;
    private String nombre;
    private Double saldo;

    @OneToMany
    private List<Vehiculo> vehiculosCliente;
    @OneToOne
    private Tarjeta tarjeta;
    @OneToMany
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
