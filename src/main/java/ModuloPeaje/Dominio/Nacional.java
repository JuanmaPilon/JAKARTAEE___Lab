package ModuloPeaje.Dominio;

import org.tallerjava.moduloA.dominio.Matricula;
import org.tallerjava.moduloA.dominio.Tag;
import org.tallerjava.moduloA.dominio.Vehiculo;

public class Nacional extends Vehiculo {
	
	private org.tallerjava.moduloA.dominio.Matricula matricula;
	
	private org.tallerjava.moduloA.dominio.Tag tag;
	
	public Nacional() {
		
	}

	public Nacional(org.tallerjava.moduloA.dominio.Matricula matricula, org.tallerjava.moduloA.dominio.Tag tag) {
		super();
		this.matricula = matricula;
		this.tag = tag;
	}

	public org.tallerjava.moduloA.dominio.Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public org.tallerjava.moduloA.dominio.Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
    
}