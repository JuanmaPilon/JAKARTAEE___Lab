package ModuloMonitoreo.interfase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import ModuloMonitoreo.infraestructura.RegistradorDeMetricas;
//import ModuloPeaje.interfase.evento.out.PeajePagoSucive;
import ModuloPeaje.Evento.PeajeVehiculoNoEncontrado;

/**
 * Observese que este Modulo si esta acoplado con el módulo de Peaje (ya que conoce sus eventos)
 * Idem para cada modulo que lanza eventos
 *
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

//    public void accept(@Observes PeajePagoSucive event) {
//        log.infof("Evento procesado: PeajePagoSucive: %s", event.getDescripcion());
//        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_PAGO_SUCIVE);
//    }
}