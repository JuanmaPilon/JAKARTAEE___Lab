package ModuloMonitoreo.Aplicacion;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModuloMonitoreo implements ModuloIMonitoreo {

    @Override
    public void notificarPasajeVehiculo() {
        System.out.println("Evento: pasaje de vehículo");
    }

    @Override
    public void notificarCobroSucive() {
        System.out.println("Evento: cobro con Sucive");
    }

    @Override
    public void notificarCobroTarjeta() {
        System.out.println("Evento: cobro con tarjeta");
    }

    @Override
    public void notificarCobroTarjetaRechazado() {
        System.out.println("Evento: rechazo de cobro por tarjeta");
    }

    @Override
    public void notificarSaldoInsuficiente() {
        System.out.println("Evento: rechazo de cobro por saldo insuficiente");
    }
}