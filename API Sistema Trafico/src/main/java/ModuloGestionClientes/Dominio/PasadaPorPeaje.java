package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.DataTipoCobro;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "gestion_PasadaPorPeaje")
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
