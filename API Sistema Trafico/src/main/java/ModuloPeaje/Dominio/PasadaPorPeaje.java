package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.DataTipoCobro;
import lombok.Data;

import java.util.Date;

@Data
public class PasadaPorPeaje {

    private Date fecha;
    private double costo;
    private DataTipoCobro tipoCobro;

    public PasadaPorPeaje() {}

    public PasadaPorPeaje(Date fecha, double costo, DataTipoCobro tipoCobro) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
    }
}
