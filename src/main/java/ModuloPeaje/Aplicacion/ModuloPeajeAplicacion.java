package ModuloPeaje.Aplicacion;

public interface ModuloPeajeAplicacion {
	
	public boolean estaHabilitado(int tag, String matricula);
	public void actualizarTarifaComun(double importe);
	public void actualizarTarifaPreferencial(double importe);
	void manejarNotificarPasajeVehiculo();

}