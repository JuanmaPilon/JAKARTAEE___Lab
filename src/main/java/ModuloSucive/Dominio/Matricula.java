package ModuloSucive.Dominio;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
	
	@Setter
    @Getter
    String nroMatricula;

	private List<Pagos> pagosMatricula;

	public Matricula() {
		this.pagosMatricula = new ArrayList<>();
	}
	
	public Matricula(String nroMatricula) {
		this.nroMatricula = nroMatricula;
		this.pagosMatricula = new ArrayList<>();
	}

	public void agregarPago(Pagos pago) {
		this.pagosMatricula.add(pago); // nuevo pago realizado por el cliente
	}

	public List<Pagos> getPagos() {
		return pagosMatricula; // todos los pagos del cliente
	}


}
