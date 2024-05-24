package ModuloPeaje.Dominio;
import lombok.Data;
import java.util.List;
import ModuloPeaje.Dominio.*;

@Data
public class Vehiculo {
    private Tag tag;
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


