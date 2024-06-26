package ModuloComunicacion.Dominio;

import java.util.Date;

public class POSTPaga extends Cuenta {
	
	private Tarjeta tarjeta;

    public POSTPaga(int nroCuenta, Date fechaApertura) {
        super(nroCuenta, fechaApertura);
    }
    public POSTPaga(int nroCuenta, Date fechaApertura, Tarjeta tarjeta) {
        super(nroCuenta, fechaApertura);
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
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
