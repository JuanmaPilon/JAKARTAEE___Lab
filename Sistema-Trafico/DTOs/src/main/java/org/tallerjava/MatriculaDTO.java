package org.tallerjava;

import java.io.Serializable;

public class MatriculaDTO implements Serializable {

	String nroMatricula;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

	public String getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
	}
	
	

}
