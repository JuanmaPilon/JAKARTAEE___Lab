package ModuloGestionClientes.Dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "gestion_Matricula")
// @Table(name = "gestion_Matricula")
public class Matricula {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	long id;
	
	String nroMatricula;
	
	public Matricula() {
		
	}
	
	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


}
