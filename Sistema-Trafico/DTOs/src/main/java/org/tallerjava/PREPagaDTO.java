package org.tallerjava;

import lombok.Data;

@Data
public class PREPagaDTO extends CuentaDTO {

	private double saldo;

	public PREPagaDTO() {
		this.saldo = getSaldo();
	}
}
