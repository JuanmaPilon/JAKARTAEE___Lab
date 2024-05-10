package ModuloPeaje.Dominio;

public class Preferencial extends ModuloPeaje.Dominio.Tarifa {
	
	public Preferencial(){

        super();
    }
    
    public Preferencial(double monto) {

        super(monto);
    }
    public double obtenerMontoPreferencial() {
        // Ahora puedes acceder al atributo monto de la clase Tarifa
        return getMontoPreferencial();
    }
    public double getMontoPreferencial() {
        return monto;
    }
}