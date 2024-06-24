package ModuloPeaje.Aplicacion;

import ModuloPeaje.Dominio.Vehiculo;

public interface ModuloPeajeAplicacion {
	
	public boolean estaHabilitado(int tag, String matricula);
	public void actualizarTarifaComun(double importe);
	public void actualizarTarifaPreferencial(double importe);
	void manejarNotificarPasajeVehiculo();
	void altaVehiculo(Vehiculo vehiculo);

}