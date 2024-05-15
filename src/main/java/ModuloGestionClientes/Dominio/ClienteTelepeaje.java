package ModuloGestionClientes.Dominio;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
// cambie por data que ya incluye setters , getters, pareses y to string y otras cosas.

@Data
public class ClienteTelepeaje {

    private String nombre;
    private String ci;
    private String email;
    private List<Vehiculo> vehiculosCliente;
    private Double saldo;
    private PREPaga cuentaPrepaga; // Cuenta de tipo PREPaga
    private POSTPaga cuentaPostpaga; // Cuenta de tipo POSTPaga
    private Tarjeta tarjeta;
    private List<PasadaPorPeaje> pasadaPorPeaje;

    public ClienteTelepeaje() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
        this.cuentaPrepaga = null;
        this.cuentaPostpaga = null;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public ClienteTelepeaje(String nombre, String ci,String email, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.vehiculosCliente = vehiculosCliente;
        this.saldo = 0.0;
        this.cuentaPrepaga = null;
        this.cuentaPostpaga = null;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public void agregarVehiculoACliente(Vehiculo vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }

    public void asignarCuentaPrepaga(PREPaga cuenta) {
        this.cuentaPrepaga = cuenta;
    }

    public void asignarCuentaPostpaga(POSTPaga cuenta) {
        this.cuentaPostpaga = cuenta;
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


