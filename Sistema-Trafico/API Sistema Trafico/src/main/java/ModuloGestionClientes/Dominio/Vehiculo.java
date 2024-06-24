package ModuloGestionClientes.Dominio;


import ModuloPeaje.Dominio.Nacionalidad;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;

@Data
@Entity(name = "gestion_Vehiculo")
@Inheritance (strategy = InheritanceType.JOINED)

// @Table(name = "gestion_Vehiculo")
public class Vehiculo {

 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
 long id;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "tag_id", referencedColumnName = "id")
 private Tag tag;

 @Column(name = "tag_idUnico")
 private String tag_idUnico;

 @OneToOne(cascade = CascadeType.ALL)
 private ClienteTelepeaje cliente;

 //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 //private List<PasadaPorPeaje> pasadaPorPeajeList;

 private Nacionalidad nacionalidad;

 // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
 public Vehiculo() {
 }

 public Vehiculo(Tag tag) {
  this.tag = tag;
  this.tag_idUnico = tag_idUnico;
  //this.pasadaPorPeajeList = pasadaPorPeajeList;
 }
 public ClienteTelepeaje getClienteTelepeaje() {
  return cliente;
 }

 public void setClienteTelepeaje(ClienteTelepeaje clienteTelepeaje) {
  this.cliente= clienteTelepeaje;}
}



