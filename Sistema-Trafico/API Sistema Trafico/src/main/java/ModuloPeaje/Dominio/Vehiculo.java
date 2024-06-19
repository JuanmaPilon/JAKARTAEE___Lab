package ModuloPeaje.Dominio;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;

@Data
@Entity(name = "peaje_Vehiculo")
@Inheritance (strategy = InheritanceType.JOINED)
// @Table(name = "peaje_Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    @Column(name = "tag_idUnico")
    private String tag_idUnico;

    @Transient
    private List<PasadaPorPeaje> pasadaPorPeajeList;

    private Nacionalidad nacionalidad;
    

    // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
    public Vehiculo() {
    }

    public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
        this.tag = tag;
        this.pasadaPorPeajeList = pasadaPorPeajeList;
    }


    public boolean nacional() {
        return nacionalidad == Nacionalidad.NACIONAL;
    }


}


