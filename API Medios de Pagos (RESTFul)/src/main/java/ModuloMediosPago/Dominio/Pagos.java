package ModuloMediosPago.Dominio;

import java.util.Date;

public class Pagos {
    private Date fecha;
    private String tipoPago; // PREpaga o POSTpaga
    private double importe;
    private String matricula;

    public Pagos(Date fecha, String tipoPago, double importe, String matricula) {
        this.fecha = fecha;
        this.tipoPago = tipoPago;
        this.importe = importe;
        this.matricula = matricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public double getImporte() {
        return importe;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
};