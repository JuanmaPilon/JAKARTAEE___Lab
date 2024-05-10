package org.tallerjava.moduloA.dominio;

import java.util.Date;
import lombok.Data;

//cambie esto por lombok, la verdad que mucho mejor la notacion

@Data
public class Cuenta {
    private int nroCuenta;
    private Date fechaApertura;

    public Cuenta(int nroCuenta, Date fechaApertura) {
        this.nroCuenta = nroCuenta;
        this.fechaApertura = fechaApertura;
    }
}
