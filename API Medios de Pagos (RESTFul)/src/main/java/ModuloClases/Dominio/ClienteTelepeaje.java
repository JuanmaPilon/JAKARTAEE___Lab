package ModuloClases.Dominio;

import lombok.Data;

import java.util.List;
// cambie por data que ya incluye setters , getters, pareses y to string y otras cosas.

@Data
public class ClienteTelepeaje {

    private String nombre;
    public Long ci;

    public ClienteTelepeaje() {};

    public ClienteTelepeaje(String nombre, Long ci) {
        this.nombre = nombre;
        this.ci = ci;
    }
}


