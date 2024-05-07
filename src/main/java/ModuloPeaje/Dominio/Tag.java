package ModuloPeaje.Dominio;

public class Tag implements Identificador {

	String idUnico;

	public Tag() {

	}

	public Tag(String idUnico) {
		this.idUnico = idUnico;
	}

	public String getIdUnico() {
		return idUnico;
	}

	public void setIdUnico(String idUnico) {
		this.idUnico = idUnico;
	}

	@Override
	public String getIdentificador() {
		return getIdUnico();
	}
}
