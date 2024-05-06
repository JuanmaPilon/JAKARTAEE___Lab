package org.tallerjava.moduloA.dominio;

import java.util.Date;

public class POSTPaga extends org.tallerjava.moduloA.dominio.Cuenta {
	
	private org.tallerjava.moduloA.dominio.Tarjeta tarjeta;

    public POSTPaga(int nroCuenta, Date fechaApertura, org.tallerjava.moduloA.dominio.Tarjeta tarjeta) {
        super(nroCuenta, fechaApertura);
        this.tarjeta = tarjeta;
    }

    public org.tallerjava.moduloA.dominio.Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(org.tallerjava.moduloA.dominio.Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "POSTPaga{" +
                "Numero de cuenta=" + getNroCuenta() +
                ", Fecha de apertura=" + getFechaApertura() +
                ", Tarjeta=" + tarjeta.getNroTarjeta() +
                '}';
    }
}
