package ModuloGestionClientes.Dominio;

import lombok.Data;

import java.util.Date;
import jakarta.persistence.*;
//cambie esto por lombok, la verdad que mucho mejor la notacion

@Data
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table(name = "gestion_cuenta")
public class Cuenta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int nroCuenta;

    private Date fechaApertura;

    public Cuenta() {} // tuve que agregar el constructor por parametros para que la clase PREPaga y POSTPaga no me tiren error con Lombok

    public Cuenta(int nroCuenta, Date fechaApertura) {
        this.nroCuenta = nroCuenta;
        this.fechaApertura = fechaApertura;
    }
}
