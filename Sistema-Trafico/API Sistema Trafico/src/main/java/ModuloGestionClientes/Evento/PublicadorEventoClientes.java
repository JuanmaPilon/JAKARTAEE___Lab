package ModuloGestionClientes.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoClientes {

    @Inject
    private Event<notCobroTarjeta> pagoTarjeta;
    @Inject
    private Event<notCobroPrePaga> pagoDebito;

    public void publicarPostPago(String mensaje){
        pagoTarjeta.fire(new notCobroTarjeta(mensaje));
    }

    public void publicarPrePago(String mensaje){
        pagoDebito.fire(new notCobroPrePaga(mensaje));
    }
}
