package ModuloPeaje.Dominio;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "peaje_Vehiculo")
@Inheritance (strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
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


    public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
        this.tag = tag;
        this.pasadaPorPeajeList = pasadaPorPeajeList;
    }
    public Vehiculo(Tag tag) {
        this.tag = tag;

    }
    public Vehiculo(Tag tag,String tag_idUnico) {
        this.tag = tag;
        this.tag_idUnico = tag_idUnico;
    }

    public boolean nacional() {
        return nacionalidad == Nacionalidad.NACIONAL;
    }


}


