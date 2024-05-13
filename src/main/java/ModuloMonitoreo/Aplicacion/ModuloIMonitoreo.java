package ModuloMonitoreo.Aplicacion;

public interface ModuloIMonitoreo {
	void notificarPasajeVehiculo(String mensaje);
	void notificarCobroSucive();
	void notificarCobroTarjeta();
	void notificarCobroTarjetaRechazado();
	void notificarSaldoInsuficiente();
}

