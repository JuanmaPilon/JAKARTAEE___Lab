package ModuloSucive.Aplicacion;

import java.util.Date;
import java.util.List;
import java.util.Set;
import ModuloSucive.Dominio.*;


public interface ModuloISucive {
	void notificarPago(Matricula matricula, double importe);
	public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal);
	public List<Pagos> consultaDePagos(Matricula matricula);
}
