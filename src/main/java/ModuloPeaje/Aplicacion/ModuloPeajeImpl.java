package ModuloPeaje.Aplicacion;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import ModuloPeaje.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.Getter;
import ModuloPeaje.Dominio.Repo.RepoPeaje;

//estahab
import org.jboss.logging.Logger;
import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;


@ApplicationScoped
public class ModuloPeajeImpl {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private Event<String> eventoPasajeVehiculo; // Evento CDI para notificar el pasaje de vehículo al módulo de Monitoreo

    @Inject
    private Event<String> vehiculoNoEncontrado;
    // Constructor que acepta el Event
    @Inject
    public ModuloPeajeImpl(Event<String> vehiculoNoEncontrado, RepoPeaje repo) {
        this.vehiculoNoEncontrado = vehiculoNoEncontrado;
        this.repo = repo;
    }

    @Getter
    private Preferencial tarifaPreferencial;

    @Getter
    private Comun tarifaComun;

    @Inject
    private RepoPeaje repo;

    public ModuloPeajeImpl(RepoPeaje repo) {
        this.repo = repo;
        double montoPredeterminado = 10.0;
        this.tarifaComun = new Comun(montoPredeterminado);
        double montoPredeterminadoPreferencial = 5.0;
        this.tarifaPreferencial = new Preferencial(montoPredeterminadoPreferencial);
    }


    public boolean estaHabilitado(int tag, String matricula) {
        log.infof("*** Verificando peaje vehiculo: tag %s, matricula: %s", tag, matricula);
        boolean habilitado = false;
        Vehiculo vehiculo = existeVehiculo(tag, matricula);
        if (vehiculo != null) {
            if (vehiculo.nacional()) {
                //mandarAQueueDePagos(vehiculo);
                habilitado = true;

            } else {
                habilitado = procesarVehiculoExtranjero(tag, vehiculo);
            }
        }

        log.infof("Resultado habilitacion tag %s, matricula %s es: %b", tag, matricula, habilitado);
        return habilitado;
    }
//    ClienteTelepeaje clienteT = new ClienteTelepeaje();
//    clienteT.setNombre("Nombre del cliente");
//        clienteT.setCi("123456789");
//        clienteT.setEmail("correo@ejemplo.com");
    //Tag tagObjeto = new Tag();

    private boolean  procesarVehiculoExtranjero(int tag, Vehiculo vehiculo) {
        log.infof("*** Procesando pago vehículo extranjero %s tag:", tag);
        boolean habilitado = false;
        // Todos los vehículos extranjeros son preferenciales
        Preferencial tarifa = repo.obtenerTarifaPreferencial();

        log.infof("Tarifa obtenida %f ", tarifa.getMontoPreferencial());

        // Realizar el pre-pago

        ModuloIGestionClientes ModuloIGestionClientes = new ModuloGestionClientes();

// Asignar vehículos si es necesario
// Asignar saldo, cuentas prepagas o postpagas si es necesario

        //ClienteTelepeaje cliente = ModuloIGestionClientes.obtenerCuentasPorTag(cliente, tag);
        //duloIGestionClientes.realizarPrePago( cliente, tarifa.getMontoPreferencial());

        // Llamar al método verificarPrePago de la instancia moduloClientes
        habilitado = ModuloIGestionClientes.verificarPrePago(tag, tarifa.getMontoPreferencial());

        log.infof("Respuesta prePago: %b ", habilitado);
        if (!habilitado) {
            //fallo el cobro prepago, intento con la tarjeta (postPago)
            habilitado = ModuloIGestionClientes.verificarPostPago(tag, tarifa.getMontoPreferencial());
            log.infof("Respuesta postPago: %b ",habilitado);
            if (!habilitado) {
                //TODO mando evento al modulo de monitoreo
                //el auto no pasa
            }
        }
        return habilitado;
    }


//    private void mandarAQueueDePagos(Vehiculo vehiculo) {
//        //TODO esto lo vamos a hacer más adelante.
//    }

    private Vehiculo existeVehiculo(int tag, String matricula) {
        Vehiculo vehiculo = repo.BuscarTag(tag);

        if (vehiculo != null) {
            log.infof("Vehiculo encontrado con tag: %s", tag);
        } else {
            vehiculo = repo.BuscarMatricula(matricula);
            if (vehiculo != null) {
                log.infof("Vehiculo encontrado con matricula: %s", tag);
            } else {
                //error grave el vehiculo no esta en el sistema
                String mensaje ="Vehiculo no encontrado: " + tag+ " " + matricula;
                vehiculoNoEncontrado.fire(mensaje);
                        ;
            }
        }
        return vehiculo;
    }

    // Método para notificar el pasaje de vehículo al módulo de Monitoreo
    public void manejarNotificarPasajeVehiculo() {
        // Lógica para determinar el pasaje de vehículo
        // Una vez que se detecta el pasaje, se envía un evento para notificar al módulo de Monitoreo
        String mensaje = "Pasaje de vehículo detectado";
        eventoPasajeVehiculo.fire(mensaje);
    }




    public ModuloPeajeImpl() {

        // Inicializa la tarifa común con un monto predeterminado
        //double montoPredeterminado = 10.0;
       //this.tarifaComun = new Comun(montoPredeterminado);
        // Inicializa la tarifa Preferencial con un monto predeterminado
        //double montoPredeterminadoPreferencial = 5.0;
        //this.tarifaPreferencial = new Preferencial(montoPredeterminadoPreferencial);
    }

    public void actualizarTarifaComun(double importe) {
        this.tarifaComun.setMonto(importe);
        //Validación o procesamiento futuro
    }


    public void actualizarTarifaPreferencial(Preferencial importe) {
        // Obtiene el monto de la tarifa preferencial actual
        double monto = importe.getMonto();

        // Actualiza el importe de la tarifa preferencial con el monto proporcionado
        this.tarifaPreferencial.setMonto(monto);

        //Validación o procesamiento futuro
    }

}
