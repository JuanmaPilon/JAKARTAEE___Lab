package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.*;
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