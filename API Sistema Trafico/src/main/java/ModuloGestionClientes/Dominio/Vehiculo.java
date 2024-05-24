package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.PasadaPorPeaje;
import ModuloGestionClientes.Dominio.Tag;
import lombok.Data;
import java.util.List;
import jakarta.persistence.*;

@Data
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table(name = "gestion_Vehiculo") //manualmente establezco el nombre de la tabla
public class Vehiculo {

 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
 long id;

 @OneToOne(cascade = CascadeType.ALL)
 private Tag tag;
 @OneToOne(cascade = CascadeType.ALL)
 private ClienteTelepeaje cliente;

 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 private List<PasadaPorPeaje> pasadaPorPeajeList;



 // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
 public Vehiculo() {
 }

 public Vehiculo(Tag tag, List<PasadaPorPeaje> pasadaPorPeajeList) {
  this.tag = tag;
  this.pasadaPorPeajeList = pasadaPorPeajeList;
 }
 public ClienteTelepeaje getClienteTelepeaje() {
  return cliente;
 }

 public void setClienteTelepeaje(ClienteTelepeaje clienteTelepeaje) {
  this.cliente= clienteTelepeaje;}
}



