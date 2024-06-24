package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.DataTipoCobro;
import ModuloGestionClientes.Dominio.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity(name = "gestion_PasadaPorPeaje")
@AllArgsConstructor
@NoArgsConstructor
// @Table(name = "gestion_PasadaPorPeaje")
public class PasadaPorPeaje {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double costo;

    @Embedded
    private DataTipoCobro tipoCobro;

    // Relación uno a uno con Vehiculo
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    private Vehiculo vehiculo;

    public PasadaPorPeaje(Date fecha, double costo, DataTipoCobro tipoCobro, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.costo = costo;
        this.tipoCobro = tipoCobro;
        this.vehiculo = vehiculo;

    }
}
