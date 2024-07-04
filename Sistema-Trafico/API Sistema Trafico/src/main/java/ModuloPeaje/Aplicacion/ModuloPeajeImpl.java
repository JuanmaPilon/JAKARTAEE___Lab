package ModuloPeaje.Aplicacion;


import ModuloComunicacion.Aplicacion.ModuloComunicacion;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import ModuloPeaje.messaging.EnviarMensajeQueue;
import ModuloPeaje.messaging.RealizadoMessage;
import ModuloSucive.Aplicacion.ModuloSucive;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Dominio.Repo.RepoPeaje;

//estahab
import org.jboss.logging.Logger;
import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;

import java.util.Date;


@ApplicationScoped
public class ModuloPeajeImpl {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    @Inject
    private EnviarMensajeQueue mensajePago;
    @Inject
    private RepoPeaje repo;

    @Inject
    private PublicadorEventoPeaje pasajeVehiculo;// Evento CDI para notificar el pasaje de vehículo al módulo de Monitoreo
    @Inject
    private ModuloComunicacion notificar;
    @Inject
    private PublicadorEventoPeaje vehiculoNoEncontrado;
    @Inject
    private PublicadorEventoPeaje eventoVehiculoExtranjero;
    @Inject
    private PublicadorEventoPeaje eventoVehiculoNacional;

    // Constructor que acepta el Event
    @Inject
    public ModuloPeajeImpl(PublicadorEventoPeaje vehiculoNoEncontrado, RepoPeaje repo) {
        this.vehiculoNoEncontrado = vehiculoNoEncontrado;
        this.repo = repo;
    }

    @Getter
    private ModuloPeaje.Dominio.Preferencial tarifaPreferencial;

    @Getter
    private ModuloPeaje.Dominio.Comun tarifaComun;


    @Inject
    private ModuloIGestionClientes moduloIGestionClientes;

    @Inject
    private ModuloSucive moduloSucive;

    @Inject
    private RepoClientes repoGestion;


    public ModuloPeajeImpl(RepoPeaje repo2) {
        this.moduloIGestionClientes = new ModuloGestionClientes();
        this.repo = repo2;
        double montoPredeterminado = 10.0;
        this.tarifaComun = new Comun(montoPredeterminado);
        double montoPredeterminadoPreferencial = 5.0;
        this.tarifaPreferencial = new Preferencial(montoPredeterminadoPreferencial);

    }
    public ModuloPeajeImpl(RepoPeaje repo2, ModuloIGestionClientes moduloIGestionClientes) {
        this.moduloIGestionClientes = moduloIGestionClientes;
        this.repo = repo2;
        double montoPredeterminado = 10.0;
        this.tarifaComun = new Comun(montoPredeterminado);
        double montoPredeterminadoPreferencial = 5.0;
        this.tarifaPreferencial = new Preferencial(montoPredeterminadoPreferencial);

    }


    public boolean estaHabilitado(String tag, String matricula) {
        log.infof("*** Verificando peaje vehiculo: tag %s, matricula: %s", tag, matricula);
        boolean habilitado = false;

        Vehiculo vehiculo = existeVehiculo(tag, matricula);
        log.infof("obtengo vehiculo " + vehiculo);
        if (vehiculo != null) {
            if (vehiculo.getNacionalidad() == Nacionalidad.NACIONAL) {
                // TODO ACA LO PROCESAR VEHICULO NACIONAL
                log.infof("MODULO PEAJE ESTA H " + vehiculo.getId() +"  "+ tag +"  "+ matricula);
                mandarAQueue (tag, vehiculo.getId(),matricula);
                habilitado = true;

                if (this.eventoVehiculoNacional != null) {
                eventoVehiculoNacional.publicarEventoVehiculoNacional("evento Vehiculo Nacional");
                }
            } else {
                habilitado = procesarVehiculoExtranjero(tag, vehiculo);
            }
        }

        log.infof("Resultado habilitacion tag %s, matricula %s es: %b", tag, matricula, habilitado);
        return habilitado;
    }

    public void mandarAQueue(String tag, Long vehiculo, String matricula){
        log.infof("MODULO PEAJE ESTA QUEUE " + vehiculo +"  "+ tag +"  "+ matricula);

        mensajePago.sendMessage(tag,vehiculo, matricula);
    }

    private boolean  procesarVehiculoExtranjero(String tag,  Vehiculo vehiculo) {
        log.infof("*** Procesando pago vehículo extranjero %s tag:", tag);
        boolean habilitado = false;
        // Todos los vehículos extranjeros son preferenciales
        Preferencial tarifa = new Preferencial(50);
        if (tarifa != null) {
        log.infof("Tarifa obtenida %f ", tarifa.getMontoPreferencial());
        // Realizar el pre-pago
        // Llamar al método verificarPrePago de la instancia moduloClientes
        habilitado = moduloIGestionClientes.realizarPrePago(tag,tarifa.getMontoPreferencial());
                //moduloIGestionClientes.verificarPrePago(tag, tarifa.getMontoPreferencial());

        log.infof("Respuesta prePago: %b ", habilitado);
        if (!habilitado) {
            //fallo el cobro prepago, intento con la tarjeta (postPago)
            habilitado = moduloIGestionClientes.realizarPostPago(tag, tarifa.getMontoPreferencial());
            log.infof("Respuesta postPago: %b ",habilitado);
            if (!habilitado) {
                //TODO mando evento al modulo de monitoreo
                //el auto no pasa
                log.infof("No pasas maestro: %s", tag);
            }
        }
        }
        else {
        // Manejar el caso en el que la tarifa es nula
        log.error("No se pudo obtener la tarifa preferencial.");
        // Podrías lanzar una excepción, retornar un valor predeterminado o realizar alguna otra acción adecuada
        }
        if (habilitado) {
            if (this.eventoVehiculoExtranjero != null) {
                eventoVehiculoExtranjero.publicarEventoVehiculoExtranjero("evento Vehiculo Extranjero");
                Date fechaActual = new Date();
                repoGestion.altaPasadaPorPeaje(tarifa.getMonto(),fechaActual,vehiculo.getId());
            }
        }
        return habilitado;
    }


    private Vehiculo existeVehiculo(String tag, String matricula) {
        log.infof("flag a");
        Vehiculo vehiculo = repo.BuscarTag(tag);
        log.infof("flag b"+ vehiculo);
        if (vehiculo != null) {
            log.infof("Vehiculo encontrado con tag: %s", vehiculo.getTag());
            log.infof(vehiculo.toString());
            return vehiculo;
        } else {
            vehiculo = repo.BuscarMatricula(matricula);
            if (vehiculo != null) {
                log.infof("Vehiculo encontrado con matricula: %s", tag);
                return vehiculo;
            } else {
                //error grave el vehiculo no esta en el sistema
                String mensaje ="Vehiculo no encontrado: " + tag+ " " + matricula;
                if (this.vehiculoNoEncontrado != null) {
                    vehiculoNoEncontrado.publicarVehiculoNoEncontrado(mensaje); // Invoca el método solo si vehiculoNoEncontrado no es nulo
                }
            }
        }
        return vehiculo;
    }

    public void altaVehiculo(Vehiculo vehiculo){
        repo.altaVehiculo(vehiculo);
    }
    // Método para notificar el pasaje de vehículo al módulo de Monitoreo
    public void manejarNotificarPasajeVehiculo() {
        if(pasajeVehiculo!= null) {
            // Lógica para determinar el pasaje de vehículo
            // Una vez que se detecta el pasaje, se envía un evento para notificar al módulo de Monitoreo
            String mensajeVehiulo = "Pasaje de vehículo detectado";
            pasajeVehiculo.publicarPasajeVehiculo(mensajeVehiulo);
        }
    }




    public ModuloPeajeImpl() {
    }

    public void actualizarTarifaComun(double importe) {
        this.tarifaComun.setMonto(importe);
        //Validación o procesamiento futuro
    }


    public void actualizarTarifaPreferencial(ModuloPeaje.Dominio.Preferencial importe) {
        // Obtiene el monto de la tarifa preferencial actual
        double monto = importe.getMonto();

        // Actualiza el importe de la tarifa preferencial con el monto proporcionado
        this.tarifaPreferencial.setMonto(monto);

        //Validación o procesamiento futuro
    }

}
