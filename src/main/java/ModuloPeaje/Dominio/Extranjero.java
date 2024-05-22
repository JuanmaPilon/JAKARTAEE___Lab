package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.Tag;
import ModuloPeaje.Dominio.Vehiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Extranjero extends Vehiculo {

	private Tag tag;


	public Extranjero(Tag tag) {
		super();

		this.tag = tag;
	}

}
