package ModuloPeaje.Dominio;

import org.tallerjava.moduloA.dominio.Tag;
import org.tallerjava.moduloA.dominio.Vehiculo;

public class Extranjero extends Vehiculo {
	
	private org.tallerjava.moduloA.dominio.Tag tag;
	

	public Extranjero(org.tallerjava.moduloA.dominio.Tag tag) {
		super();
		this.tag = tag;
	}

	public org.tallerjava.moduloA.dominio.Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
