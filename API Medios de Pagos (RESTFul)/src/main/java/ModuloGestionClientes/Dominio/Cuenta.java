package ModuloGestionClientes.Dominio;

import lombok.Data;

import java.util.Date;

//cambie esto por lombok, la verdad que mucho mejor la notacion

@Data
public class Cuenta {
    private int nroCuenta;
    private Date fechaApertura;

    public Cuenta() {} // tuve que agregar el constructor por parametros para que la clase PREPaga y POSTPaga no me tiren error con Lombok

    public Cuenta(int nroCuenta, Date fechaApertura) {
        this.nroCuenta = nroCuenta;
        this.fechaApertura = fechaApertura;
    }
}
