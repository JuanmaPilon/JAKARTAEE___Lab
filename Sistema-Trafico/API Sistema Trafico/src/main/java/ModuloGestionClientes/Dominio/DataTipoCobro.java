package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.ClienteSucive;
import ModuloGestionClientes.Dominio.POSTPaga;
import ModuloGestionClientes.Dominio.PREPaga;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class DataTipoCobro {

	@Transient
	private PREPaga prePaga;
	@Transient
	private POSTPaga postPago;
	@Transient
	private ClienteSucive clienteSucive;
	

	public DataTipoCobro(ModuloGestionClientes.Dominio.PREPaga prePaga, ModuloGestionClientes.Dominio.POSTPaga postPago, ModuloGestionClientes.Dominio.ClienteSucive clienteSucive) {
		super();
		this.prePaga = prePaga;
		this.postPago = postPago;
		this.clienteSucive = clienteSucive;
	}


}
