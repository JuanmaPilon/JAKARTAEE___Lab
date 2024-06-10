package ModuloMediosPago.Dominio;

import java.sql.Date;

public class Tarjeta {
    private int nro;
    private String nombre;
    private Date fechaVto;

    public Tarjeta(int nro, String nombre, Date fechaVto) {
        this.nro = nro;
        this.nombre = nombre;
        this.fechaVto = fechaVto;
    }

    public int getNroTarjeta() {
        return nro;
    }

    public void setNroTarjeta(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVencimiento(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    /*@Override
    public String toString() {
        return "Tarjeta{" +
                "nroTarjeta=" + nro +
                ", nombre='" + nombre + '\'' +
                ", fechaVencimiento=" + fechaVto +
                '}';
    }
     */
}