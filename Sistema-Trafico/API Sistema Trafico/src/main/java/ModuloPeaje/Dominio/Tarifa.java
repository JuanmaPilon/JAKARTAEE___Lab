package ModuloPeaje.Dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name =   "peaje_tarifa")
@Data
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
// @Table(name =   "peaje_tarifa")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private TipoTarifa tipoTarifa;

    protected double monto;

    public Tarifa() {
    }

    public Tarifa(double monto) {
        this.monto = monto;
    }

}

