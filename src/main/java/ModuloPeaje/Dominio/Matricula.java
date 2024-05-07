package ModuloPeaje.Dominio;

public class Matricula implements Identificador {

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

	@Override
	public String getIdentificador() {
		return getNroMatricula();
	}
}
