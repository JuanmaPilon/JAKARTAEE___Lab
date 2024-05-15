package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.PasadaPorPeaje;
import ModuloGestionClientes.Dominio.Tag;
import lombok.Data;
import java.util.List;

@Data
public class Vehiculo {
 private ModuloGestionClientes.Dominio.Tag tag;
 private List<PasadaPorPeaje> pasadaPorPeajeList;

 // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
 public Vehiculo() {}

 public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
  this.tag = tag;
  this.pasadaPorPeajeList = pasadaPorPeajeList;
 }
}
