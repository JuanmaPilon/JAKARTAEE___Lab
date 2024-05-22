package ModuloPeaje.Dominio;

public class Comun extends ModuloPeaje.Dominio.Tarifa {

	public Comun() {
		// Llama al constructor de la superclase Tarifa sin argumentos
		super();
	}

	public Comun(double monto) {
		// Llama al constructor de la superclase Tarifa con el monto proporcionado
		super(monto);
	}

	public double obtenerMonto() {
		// Ahora puedes acceder al atributo monto de la clase Tarifa
		return getMonto();
	}
	public double getMonto() {
		return monto;
	}
}

