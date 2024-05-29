package ModuloPeaje.Dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;


@Entity(name = "peaje_preferencial")
@Getter
@DiscriminatorValue("preferencial")
public class Preferencial extends Tarifa {
	
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