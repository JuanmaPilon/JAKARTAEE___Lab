package ModuloPeaje.Dominio;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Setter
@Getter
@Entity(name = "peaje_Matricula")
// @Table(name = "peaje_Matricula")
public class Matricula {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	long id;
	
	private String nroMatricula;

	public Matricula() {

	}

	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


}
