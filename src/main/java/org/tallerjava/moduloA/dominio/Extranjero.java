package org.tallerjava.moduloA.dominio;

public class Extranjero extends org.tallerjava.moduloA.dominio.Vehiculo {
	
	private org.tallerjava.moduloA.dominio.Tag tag;
	

	public Extranjero(org.tallerjava.moduloA.dominio.Tag tag) {
		super();
		this.tag = tag;
	}

	public org.tallerjava.moduloA.dominio.Tag getTag() {
		return tag;
	}

	public void setTag(org.tallerjava.moduloA.dominio.Tag tag) {
		this.tag = tag;
	}
}
