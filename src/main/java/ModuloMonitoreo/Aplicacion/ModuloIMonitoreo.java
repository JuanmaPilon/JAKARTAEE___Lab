package ModuloMonitoreo.Aplicacion;

public interface ModuloIMonitoreo {
	void notificarPasajeVehiculo(String mensaje);
	void notificarCobroSucive(String mensajeSucive);
	void notificarCobroTarjeta(String evento);
	void notificarCobroTarjetaRechazado();
	void notificarSaldoInsuficiente();
}

