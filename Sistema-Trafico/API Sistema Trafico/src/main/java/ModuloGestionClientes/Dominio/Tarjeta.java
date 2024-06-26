package ModuloGestionClientes.Dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "gestion_tarjeta")
// @Table (name = "gestion_tarjeta")
public class Tarjeta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int nro;

    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaVto;

    public Tarjeta(int nro, String nombre, Date fechaVto) {
        this.nro = nro;
        this.nombre = nombre;
        this.fechaVto = fechaVto;
    }
    public Tarjeta(int nro, String nombre) {
        this.nro = nro;
        this.nombre = nombre;
    }
    public Tarjeta(int nro ) {
        this.nro = nro;
    }

    public int getNroTarjeta() {
        return nro;
    }


}