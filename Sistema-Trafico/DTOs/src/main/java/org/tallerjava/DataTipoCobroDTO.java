package org.tallerjava;

import org.tallerjava.ClienteSuciveDTO;
import org.tallerjava.POSTPagaDTO;
import org.tallerjava.PREPagaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DataTipoCobroDTO {

	private PREPagaDTO prePaga;
	private POSTPagaDTO postPago;
	private ClienteSuciveDTO clienteSucive;
	

	public DataTipoCobroDTO(org.tallerjava.PREPagaDTO prePaga, org.tallerjava.POSTPagaDTO postPago, org.tallerjava.ClienteSuciveDTO clienteSucive) {
		super();
		this.prePaga = prePaga;
		this.postPago = postPago;
		this.clienteSucive = clienteSucive;
	}


}
