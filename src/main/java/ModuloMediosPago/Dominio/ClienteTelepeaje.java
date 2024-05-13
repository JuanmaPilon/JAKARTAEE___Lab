package ModuloMediosPago.Dominio;

import ModuloComunicacion.Dominio.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ClienteTelepeaje {
    @Setter
    @Getter
    private POSTPaga cuentaPOSTPaga;
    @Setter
    @Getter
    private PREPaga cuentaPREPaga;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String ci;
    @Setter
    @Getter
    private String email;

    private List<Pagos> pagosCliente;

    public ClienteTelepeaje() {
        this.pagosCliente = new ArrayList<>();
    }
    public ClienteTelepeaje(String nombre, String ci,String email) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.pagosCliente = new ArrayList<>();
    }
    public void agregarPago(Pagos pago) {
        this.pagosCliente.add(pago); // nuevo pago realizado por el cliente
    }

    public List<Pagos> getPagos() {
        return pagosCliente; // todos los pagos del cliente
    }
}




