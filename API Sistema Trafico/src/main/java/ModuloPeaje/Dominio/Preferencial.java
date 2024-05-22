package ModuloPeaje.Dominio;

public class Preferencial extends ModuloPeaje.Dominio.Tarifa {
	
	public Preferencial(){

        super();
    }

    public Preferencial(double monto) {
        this.monto= monto;
    }
    public double obtenerMonto() {
        // Ahora puedes acceder al atributo monto de la clase Tarifa
        return getMonto();
    }
    public double getMontoPreferencial() {
        return monto;
    }
}