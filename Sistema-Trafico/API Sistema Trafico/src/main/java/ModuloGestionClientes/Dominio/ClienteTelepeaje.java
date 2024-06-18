package ModuloGestionClientes.Dominio;

import lombok.Data;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// cambie por data que ya incluye setters , getters, pareses y to string y otras cosas.

@Data
@Entity(name = "gestion_clienteTelepeaje")
// @Table(name = "gestion_clienteTelepeaje")
public class ClienteTelepeaje {


    @Id
    private String ci;

    private String nombre;
    private String email;
    private Double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "cuenta_prepaga_id", referencedColumnName = "id")
    private PREPaga cuentaPrepaga; // Cuenta de tipo PREPaga


    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "postpaga_id", referencedColumnName = "id")
    private POSTPaga cuentaPostpaga; // Cuenta de tipo POSTPaga

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "tarjeta_id", referencedColumnName = "id")
    private Tarjeta tarjeta;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> vehiculosCliente;

    public ClienteTelepeaje() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
        this.cuentaPrepaga = null;
        this.cuentaPostpaga = null;
        this.tarjeta = null;

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


}


