package ModuloClases.Dominio;

import lombok.Data;
import java.util.List;

@Data
public class Vehiculo {
    private Tag tag;
    private List<PasadaPorPeaje> pasadaPorPeajeList;

    // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
    public Vehiculo() {}

    public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
        this.tag = tag;
        this.pasadaPorPeajeList = pasadaPorPeajeList;
    }
}
