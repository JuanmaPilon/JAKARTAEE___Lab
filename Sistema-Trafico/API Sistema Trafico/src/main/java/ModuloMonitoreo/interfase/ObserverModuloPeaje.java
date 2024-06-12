package ModuloMonitoreo.interfase;

import ModuloPeaje.Evento.eventoVehiculoExtranjero;
import ModuloPeaje.Evento.eventoVehiculoNacional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import ModuloMonitoreo.infraestructura.RegistradorDeMetricas;
import ModuloSucive.Evento.notificarPagoSucive;
import ModuloPeaje.Evento.PeajeVehiculoNoEncontrado;
import ModuloGestionClientes.Evento.notCobroTarjeta;
import ModuloGestionClientes.Evento.notCobroPrePaga;

/**
 * Observese que este Modulo si esta acoplado con el módulo de Peaje (ya que conoce sus eventos)
 * Idem para cada modulo que lanza eventos
 * Un nivel mayor de desacoplamiento lo podemos lograr con JMS
 *
 */
@ApplicationScoped
public class ObserverModuloPeaje {
    private static final Logger log = Logger.getLogger(ObserverModuloPeaje.class);

    @Inject
    private RegistradorDeMetricas register;

    public void accept(@Observes PeajeVehiculoNoEncontrado event) {
        log.infof("Evento procesado: PeajeVehiculoNoEncontrado: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_VEHICULO_NO_ENCONTRADO);
    }

    public void accept(@Observes notificarPagoSucive event) {
        log.infof("Evento procesado: PeajePagoSucive: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_PAGO_SUCIVE);
    }

    public void accept(@Observes notCobroTarjeta event) {
        log.infof("Evento procesado: PostPago: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.GESTION_COUNTER_POST_PAGO);
    }

    public void accept(@Observes notCobroPrePaga event) {
        log.infof("Evento procesado: PrePago: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.GESTION_COUNTER_PRE_PAGO);
    }
    public void accept(@Observes eventoVehiculoExtranjero event) {
        log.infof("Evento procesado: Vehiculo Extranjero: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_VEHICULO_EXTRANJERO);
    }
    public void accept(@Observes eventoVehiculoNacional event) {
        log.infof("Evento procesado: Vehiculo Nacional: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_VEHICULO_NACIONAL);
    }

}