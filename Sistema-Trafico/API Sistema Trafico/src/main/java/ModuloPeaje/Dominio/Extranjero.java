package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.Tag;
import ModuloPeaje.Dominio.Vehiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "peaje_vehiculoExtranjero")
@NoArgsConstructor
// @Table(name = "peaje_vehiculoExtranjero")
public class Extranjero extends Vehiculo {


	public Extranjero(Tag tag) {
		super(tag);
	}
	public Extranjero(Tag tag, String tag_idUnico) {
		super(tag, tag_idUnico);
	}
}
