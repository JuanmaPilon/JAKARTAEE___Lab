package ModuloComunicacion.Dominio;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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

    public ClienteTelepeaje() {
    }
    public ClienteTelepeaje(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
    }


}


