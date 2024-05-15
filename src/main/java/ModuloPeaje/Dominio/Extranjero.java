package ModuloPeaje.Dominio;

import ModuloClases.Dominio.Tag;
import ModuloClases.Dominio.Vehiculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Extranjero extends Vehiculo {

	private Tag tag;


	public Extranjero(Tag tag) {
		super();
		this.tag = tag;
	}

}
