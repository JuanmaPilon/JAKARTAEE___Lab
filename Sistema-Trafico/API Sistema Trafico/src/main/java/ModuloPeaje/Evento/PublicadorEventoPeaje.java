package ModuloPeaje.Evento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoPeaje {
    @Inject
    private Event<notificarPasajeVehiculo> pasajeVehiculo;
    @Inject
    private Event<PeajeVehiculoNoEncontrado> vehiculoNoEncontrado;
    @Inject
    private Event<eventoVehiculoExtranjero> vehiculoExtranjero;
    @Inject
    private Event<eventoVehiculoNacional> vehiculoNacional;

    public void publicarVehiculoNoEncontrado(String mensaje){
        vehiculoNoEncontrado.fire(new PeajeVehiculoNoEncontrado(mensaje));
    }
    public void publicarPasajeVehiculo(String mensaje){
        pasajeVehiculo.fire(new notificarPasajeVehiculo(mensaje));
    }
    public void publicarEventoVehiculoExtranjero(String mensaje){
        if (mensaje != null) {
        vehiculoExtranjero.fire(new eventoVehiculoExtranjero(mensaje));
        }
    }
    public void publicarEventoVehiculoNacional(String mensaje){
        if (mensaje != null) {
        vehiculoNacional.fire(new eventoVehiculoNacional(mensaje));
        }
    }
}
