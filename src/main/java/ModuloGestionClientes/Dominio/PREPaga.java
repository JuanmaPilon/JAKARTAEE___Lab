package ModuloGestionClientes.Dominio;

import ModuloClases.Dominio.Cuenta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) //faltaba esta linea sino no incluye llamadas del metodo base
@Data
public class PREPaga extends Cuenta {

	private double saldo;

	//agrehgado correctamente el constructor

	public PREPaga() {
		this.saldo = getSaldo();
	}
}
