package ModuloMediosPago.Dominio;

import java.util.Date;

public class PasadaPorPeaje {
	
    private Date fecha;
    private double costo;
    private org.tallerjava.moduloA.dominio.DataTipoCobro tipoCobro;

    public PasadaPorPeaje(Date fecha, double costo, org.tallerjava.moduloA.dominio.DataTipoCobro tipoCobro) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public org.tallerjava.moduloA.dominio.DataTipoCobro getTipoCobro() {
        return tipoCobro;
    }

    public void setTipoCobro(org.tallerjava.moduloA.dominio.DataTipoCobro tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

    @Override
    public String toString() {
        return "PasadaPorPeaje{" +
                "Fecha=" + fecha +
                ", Costo=" + costo +
                ", Tipo de Cobro=" + tipoCobro +
                '}';
    }
}