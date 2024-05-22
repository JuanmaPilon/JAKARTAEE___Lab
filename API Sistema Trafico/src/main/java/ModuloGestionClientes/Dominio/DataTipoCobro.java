package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.ClienteSucive;
import ModuloGestionClientes.Dominio.POSTPaga;
import ModuloGestionClientes.Dominio.PREPaga;

public class DataTipoCobro {

	private ModuloGestionClientes.Dominio.PREPaga prePaga;
	private ModuloGestionClientes.Dominio.POSTPaga postPago;
	private ModuloGestionClientes.Dominio.ClienteSucive clienteSucive;
	

	public DataTipoCobro(ModuloGestionClientes.Dominio.PREPaga prePaga, ModuloGestionClientes.Dominio.POSTPaga postPago, ModuloGestionClientes.Dominio.ClienteSucive clienteSucive) {
		super();
		this.prePaga = prePaga;
		this.postPago = postPago;
		this.clienteSucive = clienteSucive;
	}

	public PREPaga getPrePaga() {
		return prePaga;
	}

	public POSTPaga getPostPago() {
		return postPago;
	}

	public ClienteSucive getClienteSucive() {
		return clienteSucive;
	}


}
