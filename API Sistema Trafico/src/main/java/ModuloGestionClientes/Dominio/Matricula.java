package ModuloGestionClientes.Dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "gestion_Matricula")
public class Matricula {

	@Id
	String nroMatricula;
	
	public Matricula() {
		
	}
	
	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

	public String getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}
	
	

}
