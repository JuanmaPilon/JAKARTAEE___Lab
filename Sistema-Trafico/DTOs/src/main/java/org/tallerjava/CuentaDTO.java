package org.tallerjava;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class CuentaDTO implements Serializable {
    private int nroCuenta;

    private Date fechaApertura;

    public CuentaDTO() {} // tuve que agregar el constructor por parametros para que la clase PREPaga y POSTPaga no me tiren error con Lombok

    public CuentaDTO(int nroCuenta, Date fechaApertura) {
        this.nroCuenta = nroCuenta;
        this.fechaApertura = fechaApertura;
    }
}
