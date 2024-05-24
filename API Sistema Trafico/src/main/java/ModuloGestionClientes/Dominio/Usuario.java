package ModuloGestionClientes.Dominio;

import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table(name = "gestion_usuario")
public class Usuario {

    @Id
    private String ci;
    private String nom;
    private String email;
    @OneToOne
    private ClienteTelepeaje cliente;



    public Usuario() {}

    public Usuario(String ci, String nom, String email) {
        this.ci = ci;
        this.nom = nom;
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombreUsuario() {
        return nom;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nom = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



public ClienteTelepeaje getClienteTelepeaje() {
    return cliente;
}

public void setClienteTelepeaje(ClienteTelepeaje clienteTelepeaje) {
    this.cliente = clienteTelepeaje;
}

}