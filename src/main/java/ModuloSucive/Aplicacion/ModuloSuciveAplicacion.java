package ModuloSucive.Aplicacion;

import java.util.Date;
import java.util.List;

import org.tallerjava.moduloA.dominio.*;//*******************

public interface ModuloSuciveAplicacion {
	void notificarPago(Matricula matricula, double importe);
	//public List<Pagos> consultaDePagos(Date fechaInicial, Date fecha);
    //public Pagos consultaDePagos(Ma tricula matricula);
}
