package ModuloGestionClientes.Dominio;

import ModuloClases.Dominio.Cuenta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

// deje el tarjeta anterior pero no ser porque no me esta tomando la clase importada tarjeta

@EqualsAndHashCode(callSuper = true) //faltaba esta linea sino no incluye llamadas del metodo base
@Data
public class POSTPaga extends Cuenta {

    private double saldo;
    private Tarjeta tarjeta;

    //agrehgado correctamente el constructor

    public POSTPaga(int nroCuenta,Date fechaApertura, Tarjeta tarjeta) {
        super(nroCuenta, fechaApertura);
        this.tarjeta = tarjeta;
    }
}


//package org.tallerjava.moduloA.dominio;
//
//import java.util.Date;
//
//public class POSTPaga extends org.tallerjava.moduloA.dominio.Cuenta {
//
//    private org.tallerjava.moduloA.dominio.Tarjeta tarjeta;
//
//    public POSTPaga(int nroCuenta, Date fechaApertura, org.tallerjava.moduloA.dominio.Tarjeta tarjeta) {
//        super(nroCuenta, fechaApertura);
//        this.tarjeta = tarjeta;
//    }
//
//    public org.tallerjava.moduloA.dominio.Tarjeta getTarjeta() {
//        return tarjeta;
//    }
//
//    public void setTarjeta(org.tallerjava.moduloA.dominio.Tarjeta tarjeta) {
//        this.tarjeta = tarjeta;
//    }
//
//    @Override
//    public String toString() {
//        return "POSTPaga{" +
//                "Numero de cuenta=" + getNroCuenta() +
//                ", Fecha de apertura=" + getFechaApertura() +
//                ", Tarjeta=" + tarjeta.getNroTarjeta() +
//                '}';
//    }
//}
