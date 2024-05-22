package ModuloPeaje.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoPeaje {
    @Inject
    private Event<notificarPasajeVehiculo> pasajeVehiculo;

    public void publicarPasajeVehiculo(String mensaje){
        pasajeVehiculo.fire(new notificarPasajeVehiculo(mensaje));
    }
}
