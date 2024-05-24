package ModuloPeaje.Dominio;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "peaje_Matricula")
public class Matricula {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	String id;

	private String nroMatricula;

	public Matricula() {

	}

	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


}
