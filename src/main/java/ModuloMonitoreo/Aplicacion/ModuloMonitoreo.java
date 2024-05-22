package ModuloMonitoreo.Aplicacion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import ModuloSucive.Evento.notificarPagoSucive;
import ModuloPeaje.Evento.notificarPasajeVehiculo;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ModuloMonitoreo {

    // Método anotado con @Observes para escuchar el evento de pasaje de vehículo enviado desde el módulo de Peaje

    public void notificarPeajeVehiculo(@Observes notificarPasajeVehiculo event) {
        // Manejar el evento de pasaje de vehículo recibido desde el módulo de Peaje
        System.out.println(event.getDescripcion());
    }


    public void notificarCobroSucive(@Observes notificarPagoSucive event) {
        System.out.println(event.getDescripcion());
    }



    public void notificarCobroTarjeta(@Observes String evento) {
        // Manejar el evento de pago recibido desde el módulo de MediosPago
        System.out.println("Evento de pago recibido: " + evento);
    }


    public void notificarCobroTarjetaRechazado(@Observes String mensajeTarjeta) {
        System.out.println("Evento: rechazo de cobro por tarjeta" + mensajeTarjeta);
    }


    public void notificarSaldoInsuficiente(@Observes String mensajeTarjeta) {
         System.out.println("Evento: rechazo de cobro por saldo insuficiente" + mensajeTarjeta);
    }
}