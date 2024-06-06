package ModuloGestionClientes.Dominio;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

// deje la tarjeta anterior, pero no ser porque no me está tomando la clase importada tarjeta
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) //faltaba esta línea si no no incluye llamadas del método base
@Data
@NoArgsConstructor
@Entity(name = "gestion_cuentaPostPaga")
// @Table (name = "gestion_cuentaPostPaga")
public class POSTPaga extends Cuenta {

    private double saldo;
    @OneToOne
    private Tarjeta tarjeta;

    //agregado correctamente el constructor

    public POSTPaga(int nroCuenta,Date fechaApertura, Tarjeta tarjeta) {
        super(nroCuenta, fechaApertura);
        this.tarjeta = tarjeta;
    }
    public POSTPaga(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
