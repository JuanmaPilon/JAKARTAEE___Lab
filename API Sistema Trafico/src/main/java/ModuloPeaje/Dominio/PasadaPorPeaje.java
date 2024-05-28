package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.DataTipoCobro;
import lombok.Data;
import java.util.Date;
import jakarta.persistence.*;

@Data
@Entity(name = "peaje_PasadaPorPeaje")
// @Table(name = "peaje_PasadaPorPeaje")
public class PasadaPorPeaje {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    private Date fecha;
    private double costo;

    @Embedded
    private DataTipoCobro tipoCobro;

    public PasadaPorPeaje() {}

    public PasadaPorPeaje(Date fecha, double costo, DataTipoCobro tipoCobro) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
    }
}
