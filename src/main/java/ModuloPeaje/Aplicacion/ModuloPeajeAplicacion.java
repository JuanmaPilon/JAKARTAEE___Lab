package ModuloPeaje.Aplicacion;

public interface ModuloPeajeAplicacion {
	
	public boolean estaHabilitado(Object identificador);
	public void actualizarTarifaComun(double importe);
	public void actualizarTarifaPreferencial(double importe);
	void manejarNotificarPasajeVehiculo();

}