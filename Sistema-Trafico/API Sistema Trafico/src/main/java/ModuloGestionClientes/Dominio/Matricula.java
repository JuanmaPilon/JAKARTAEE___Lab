package ModuloGestionClientes.Dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "gestion_Matricula")
// @Table(name = "gestion_Matricula")
public class Matricula {

	@Id
	String nroMatricula;
	
	public Matricula() {
		
	}
	
	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


}
