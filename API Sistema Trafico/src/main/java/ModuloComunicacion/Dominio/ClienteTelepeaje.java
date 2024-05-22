package ModuloComunicacion.Dominio;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteTelepeaje {
    @Setter
    @Getter
    private POSTPaga cuentaPOSTPaga;
    @Setter
    @Getter
    private PREPaga cuentaPREPaga;
    @Setter
    @Getter
    private String nombre;
    @Setter
    @Getter
    private String ci;
    @Setter
    @Getter
    private String email;

    private List<String> notificaciones;

    public ClienteTelepeaje() {
        this.notificaciones = new ArrayList<>();
    }
    public ClienteTelepeaje(String nombre, String ci,String email) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.notificaciones = new ArrayList<>();
    }
    public void agregarNotificacion(String notificacion) {
        this.notificaciones.add(notificacion); // nueva notificacion para el cliente
    }

    public List<String> getNotificaciones() {
        return notificaciones; // todas las notificaciones del cliente
    }
}


