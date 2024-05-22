package ModuloGestionClientes.Dominio;

import ModuloMediosPago.Dominio.ClienteTelepeaje;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario {
    private String ci;
    private String nom;
    private String email;
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