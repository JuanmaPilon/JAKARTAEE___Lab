package org.tallerjava;

import org.tallerjava.ClienteTelepeajeDTO;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
public class UsuarioDTO {

    private String ci;
    private String nom;
    private String email;
    private ClienteTelepeajeDTO cliente;



    public UsuarioDTO() {}

    public UsuarioDTO(String ci, String nom, String email) {
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



public ClienteTelepeajeDTO getClienteTelepeaje() {
    return cliente;
}

public void setClienteTelepeaje(ClienteTelepeajeDTO clienteTelepeaje) {
    this.cliente = clienteTelepeaje;
}

}