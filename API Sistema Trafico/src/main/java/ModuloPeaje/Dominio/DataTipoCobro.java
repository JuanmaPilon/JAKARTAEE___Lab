package ModuloPeaje.Dominio;

import ModuloMediosPago.Dominio.ClienteSucive;
import ModuloMediosPago.Dominio.POSTPaga;
import ModuloMediosPago.Dominio.PREPaga;

public class DataTipoCobro {

    private ModuloMediosPago.Dominio.PREPaga prePaga;
    private ModuloMediosPago.Dominio.POSTPaga postPago;
    private ClienteSucive clienteSucive;


    public DataTipoCobro(ModuloMediosPago.Dominio.PREPaga prePaga, ModuloMediosPago.Dominio.POSTPaga postPago, ClienteSucive clienteSucive) {
        super();
        this.prePaga = prePaga;
        this.postPago = postPago;
        this.clienteSucive = clienteSucive;
    }

    public PREPaga getPrePaga() {
        return prePaga;
    }

    public POSTPaga getPostPago() {
        return postPago;
    }

    public ClienteSucive getClienteSucive() {
        return clienteSucive;
    }


}