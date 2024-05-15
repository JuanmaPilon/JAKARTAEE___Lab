package ModuloPeaje.Dominio;
import ModuloClases.Dominio.PasadaPorPeaje;
import ModuloClases.Dominio.Tag;
import lombok.Data;
import java.util.List;

@Data
public class Vehiculo {
    private ModuloClases.Dominio.Tag tag;
    private List<PasadaPorPeaje> pasadaPorPeajeList;

    // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
    public Vehiculo() {
    }

    public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
        this.tag = tag;
        this.pasadaPorPeajeList = pasadaPorPeajeList;
    }
    private long id;
    private Nacionalidad nacionalidad;

    public boolean nacional() {
        return nacionalidad == Nacionalidad.NACIONAL;
    }
}
