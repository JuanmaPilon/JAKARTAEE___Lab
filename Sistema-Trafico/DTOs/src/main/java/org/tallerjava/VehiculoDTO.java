package org.tallerjava;

import org.tallerjava.PasadaPorPeajeDTO;
import org.tallerjava.TagDTO;
import org.tallerjava.ClienteTelepeajeDTO;
import lombok.Data;
import java.util.List;

@Data
public class Vehiculo {

 long id;
 private TagDTO tag;
 private ClienteTelepeajeDTO cliente;

 private List<PasadaPorPeajeDTO> pasadaPorPeajeList;

 // creo que el constructor vacio, porque sino cuando tag y las otras hereden los metodos, se rompe con lombok
 public VehiculoDTO() {
 }

 public VehiculoDTO(TagDTO tag, List<PasadaPorPeajeDTO> pasadaPorPeajeList) {
  this.tag = tag;
  this.pasadaPorPeajeList = pasadaPorPeajeList;
 }
 public ClienteTelepeajeDTO getClienteTelepeaje() {
  return cliente;
 }

 public void setClienteTelepeaje(ClienteTelepeajeDTO clienteTelepeaje) {
  this.cliente= clienteTelepeaje;}
}



