package ModuloPeaje.Dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Matricula {

	String nroMatricula;

	public Matricula() {

	}

	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


}
