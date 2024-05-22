package ModuloMonitoreo.Aplicacion;

import jakarta.enterprise.event.Observes;

public interface ModuloIMonitoreo {
	void notificarPasajeVehiculo(String mensaje);
	void notificarCobroSucive(String mensajeSucive);
	void notificarCobroTarjeta(String evento);
	void notificarCobroTarjetaRechazado(String mensajeTarjeta);
	void notificarSaldoInsuficiente(String mensajeTarjeta);
}

