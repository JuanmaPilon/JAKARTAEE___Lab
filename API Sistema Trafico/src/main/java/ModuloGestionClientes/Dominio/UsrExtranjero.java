package ModuloGestionClientes.Dominio;

import jakarta.persistence.*;

@Entity
@Table (name = "gestion_usrExtranjero")
public class UsrExtranjero extends Usuario {

    public UsrExtranjero() {
        super();
    }

    public UsrExtranjero(String ci, String nombreUsuario, String email) {
        super(ci, nombreUsuario, email);
    }
}