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

	@OneToOne(cascade = CascadeType.ALL)
	private Tag tag;


	public Extranjero(Tag tag) {
		super();

		this.tag = tag;
	}

}
