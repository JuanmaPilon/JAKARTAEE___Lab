package ModuloGestionClientes.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoClientes {
    // notificarCobroTarjeta()
    // notificarCobroTarjetaRechazado()
    // notificarSaldoInsuficiente()
    @Inject
    private Event<notCobroTarjeta> pagoTarjeta;

    public void publicarPago(String mensaje){
        pagoTarjeta.fire(new notCobroTarjeta(mensaje));
    }
}
