package org.tallerjava;

import org.tallerjava.DataTipoCobroDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PasadaPorPeajeDTO implements Serializable {
    long id;

    private Date fecha;
    private double costo;


    private DataTipoCobroDTO tipoCobro;

    public PasadaPorPeajeDTO() {}

    public PasadaPorPeajeDTO(Date fecha, double costo, DataTipoCobroDTO tipoCobro) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
    }
}
