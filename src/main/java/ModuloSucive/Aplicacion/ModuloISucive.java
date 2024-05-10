package ModuloSucive.Aplicacion;

import java.util.Date;
import java.util.Set;
import ModuloSucive.Dominio.*;


public interface ModuloISucive {
	void notificarPago(Matricula matricula, double importe);
	Set<Pagos> consultaDePagos(Date fechaInicial, Date fecha);
	Set<Pagos> consultaDePagos(Matricula matricula);
}
