package ModuloPeaje.Dominio;

public class Tarifa {
    protected double monto;

    public Tarifa() {
    }

    public Tarifa(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

