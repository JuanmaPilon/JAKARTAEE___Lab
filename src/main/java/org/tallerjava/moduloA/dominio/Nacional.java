package org.tallerjava.moduloA.dominio;

public class Nacional extends org.tallerjava.moduloA.dominio.Vehiculo {
	
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

	public void setMatricula(org.tallerjava.moduloA.dominio.Matricula matricula) {
		this.matricula = matricula;
	}

	public org.tallerjava.moduloA.dominio.Tag getTag() {
		return tag;
	}

	public void setTag(org.tallerjava.moduloA.dominio.Tag tag) {
		this.tag = tag;
	}
	
    
}