package ModuloGestionClientes.Dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) //faltaba esta linea sino no incluye llamadas del metodo base
@Data
@Entity(name = "gestion_cuentaPrePaga")
// @Table(name = "gestion_cuentaPrePaga")
public class PREPaga extends Cuenta {


	private double saldo;

	//agrehgado correctamente el constructor

	public PREPaga() {
		this.saldo = getSaldo();
	}
}
