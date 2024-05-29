package ModuloMediosPago.Dominio;

public class Usuario {
    private String ci;
    private String nom;
    private String email;
    private ClienteTelepeaje clienteTelepeaje;
    
    public Usuario() {
    	
    }
    
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
        return clienteTelepeaje;
    }

    public void setClienteTelepeaje(ClienteTelepeaje clienteTelepeaje) {
        this.clienteTelepeaje = clienteTelepeaje;
    }
}