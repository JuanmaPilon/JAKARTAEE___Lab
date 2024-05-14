package ModuloMonitoreo.Aplicacion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ModuloMonitoreo implements ModuloIMonitoreo {

    // Método anotado con @Observes para escuchar el evento de pasaje de vehículo enviado desde el módulo de Peaje
    @Override
    public void notificarPasajeVehiculo(@Observes String mensaje) {
        // Manejar el evento de pasaje de vehículo recibido desde el módulo de Peaje
        System.out.println("Evento de pasaje de vehículo: " + mensaje);
    }
    @Override
    public void notificarCobroSucive(@Observes String mensajeSucive) {

        System.out.println("Evento: cobro con Sucive" + mensajeSucive);
    }

    @Override
    public void notificarCobroTarjeta(@Observes String evento) {
        // Manejar el evento de pago recibido desde el módulo de MediosPago
        System.out.println("Evento de pago recibido: " + evento);
    }

    @Override
    public void notificarCobroTarjetaRechazado(@Observes String mensajeTarjeta) {
        System.out.println("Evento: rechazo de cobro por tarjeta" + mensajeTarjeta);
    }

    @Override
    public void notificarSaldoInsuficiente(@Observes String mensajeTarjeta) {
         System.out.println("Evento: rechazo de cobro por saldo insuficiente" + mensajeTarjeta);
    }
}