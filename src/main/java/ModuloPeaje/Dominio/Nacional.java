package ModuloPeaje.Dominio;

import ModuloClases.Dominio.Matricula;
import ModuloClases.Dominio.Tag;
import ModuloClases.Dominio.Vehiculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Nacional extends Vehiculo {

	private Matricula matricula;

	private Tag tag;

	public Nacional() {

	}

	public Nacional(Matricula matricula, Tag tag) {
		super();
		this.matricula = matricula;
		this.tag = tag;
	}


}