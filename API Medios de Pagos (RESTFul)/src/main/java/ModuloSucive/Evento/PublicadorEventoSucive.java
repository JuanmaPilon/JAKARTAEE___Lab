package ModuloSucive.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoSucive {
    @Inject
    private Event<notificarPagoSucive> pagoSucive;

    public void publicarPagoSucive(String mensaje){
        pagoSucive.fire(new notificarPagoSucive(mensaje));
    }
}
