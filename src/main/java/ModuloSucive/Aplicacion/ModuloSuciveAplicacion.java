package ModuloSucive.Aplicacion;

import java.util.Date;
import java.util.Set;
import ModuloSucive.Dominio.Pagos;

import org.tallerjava.moduloA.dominio.*;//*******************

public interface ModuloSuciveAplicacion {
	void notificarPago(Matricula matricula, double importe);
	Set<Pagos> consultaDePagos(Date fechaInicial, Date fecha);
	Set<Pagos> consultaDePagos(Matricula matricula);
}
