package ModuloGestionClientes.Dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;


@EqualsAndHashCode(callSuper = true) //faltaba esta linea sino no incluye llamadas del metodo base
@Data
@Entity
@Table(name = "gestion_cuentaPrePaga")
public class PREPaga extends Cuenta {


	private double saldo;

	//agrehgado correctamente el constructor

	public PREPaga() {
		this.saldo = getSaldo();
	}
}
