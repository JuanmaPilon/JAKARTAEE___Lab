package ModuloPeaje.Dominio;

import ModuloMediosPago.Dominio.ClienteSucive;
import ModuloMediosPago.Dominio.POSTPaga;
import ModuloMediosPago.Dominio.PREPaga;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class DataTipoCobro {

    @Transient
    private PREPaga prePaga;
    @Transient
    private POSTPaga postPago;
    @Transient
    private ClienteSucive clienteSucive;


    public DataTipoCobro(ModuloMediosPago.Dominio.PREPaga prePaga, ModuloMediosPago.Dominio.POSTPaga postPago, ClienteSucive clienteSucive) {
        super();
        this.prePaga = prePaga;
        this.postPago = postPago;
        this.clienteSucive = clienteSucive;
    }

}