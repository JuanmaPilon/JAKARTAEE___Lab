package ModuloPeaje.Dominio;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name =   "peaje_tarifa")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @Table(name =   "peaje_tarifa")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected double monto;

    public Tarifa() {
    }

    public Tarifa(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

