package ModuloClases.Dominio;

import lombok.Data;

// mismo que las otras clases, tambien hay que quitar las otras viejas desactualizadas de cada modulo y solo ponerlos aca

@Data
public class ClienteSucive {

    private String nombre;
    // no me lo agarra usr nacional si es private, lo cambio a public, pero no se si estara bien
    public long ci;

    public ClienteSucive() {}

    public ClienteSucive(String nombre, Long ci) {
        this.nombre = nombre;
        this.ci = ci;
    }

}
