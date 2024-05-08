package ModuloComunicacion.Dominio;


import java.util.Date;

public class ClienteTelepeaje {
    private POSTPaga cuentaPOSTPaga;
    private PREPaga cuentaPREPaga;

    public ClienteTelepeaje() {
    }

    public POSTPaga getCuentaPOSTPaga() {
        return cuentaPOSTPaga;
    }
    public PREPaga getCuentaPREPaga() {
        return cuentaPREPaga;
    }

    public void setCuentaPOSTPaga(POSTPaga cuentaPOSTPaga) {
        this.cuentaPOSTPaga = cuentaPOSTPaga;
    }
    public void setCuentaPREPaga(PREPaga cuentaPREPaga) {
        this.cuentaPREPaga = cuentaPREPaga;
    }
}


