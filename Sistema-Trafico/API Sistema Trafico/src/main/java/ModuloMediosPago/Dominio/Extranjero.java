package ModuloMediosPago.Dominio;

public class Extranjero extends Vehiculo {
	
	private Tag tag;
	

	public Extranjero(Tag tag) {
		super();
		this.tag = tag;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
