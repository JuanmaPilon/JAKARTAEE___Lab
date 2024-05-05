package org.tallerjava.moduloA.dominio;

public class DataTipoCobro {

	private org.tallerjava.moduloA.dominio.PREPaga prePaga;
	private org.tallerjava.moduloA.dominio.POSTPaga postPago;
	private org.tallerjava.moduloA.dominio.ClienteSucive clienteSucive;
	

	public DataTipoCobro(org.tallerjava.moduloA.dominio.PREPaga prePaga, org.tallerjava.moduloA.dominio.POSTPaga postPago, org.tallerjava.moduloA.dominio.ClienteSucive clienteSucive) {
		super();
		this.prePaga = prePaga;
		this.postPago = postPago;
		this.clienteSucive = clienteSucive;
	}

	public org.tallerjava.moduloA.dominio.PREPaga getPrePaga() {
		return prePaga;
	}

	public org.tallerjava.moduloA.dominio.POSTPaga getPostPago() {
		return postPago;
	}

	public org.tallerjava.moduloA.dominio.ClienteSucive getClienteSucive() {
		return clienteSucive;
	}


}
