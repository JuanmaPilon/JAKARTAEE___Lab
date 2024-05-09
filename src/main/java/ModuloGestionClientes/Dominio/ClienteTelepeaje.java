package ModuloGestionClientes.Dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClienteTelepeaje {
    private String nombre;
    private String ci;

    public ClienteTelepeaje(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
    }
}


