package ModuloGestionClientes.Dominio;

import jakarta.persistence.*;

@Entity
@Table (name = "gestion_usrNacional")
public class UsrNacional extends Usuario {

    public UsrNacional() {
        super();
    }

    public UsrNacional(String ci, String nombreUsuario, String email) {
        super(ci, nombreUsuario, email);
    }
}