package org.tallerjava;

import org.tallerjava.DataTipoCobroDTO;
import lombok.Data;
import java.util.Date;

@Data
public class PasadaPorPeajeDTO {
    long id;

    private Date fecha;
    private double costo;

    @Embedded
    private DataTipoCobro tipoCobro;

    public PasadaPorPeajeDTO() {}

    public PasadaPorPeajeDTO(Date fecha, double costo, DataTipoCobro tipoCobro) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
    }
}
