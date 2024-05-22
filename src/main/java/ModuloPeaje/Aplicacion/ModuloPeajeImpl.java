package ModuloPeaje.Aplicacion;


import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.Getter;
import ModuloPeaje.Dominio.*;
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
    private ModuloPeaje.Dominio.Preferencial tarifaPreferencial;

    @Getter
    private ModuloPeaje.Dominio.Comun tarifaComun;

    @Inject
    private RepoPeaje repo;

    @Inject
    private ModuloIGestionClientes moduloIGestionClientes;


    public ModuloPeajeImpl(RepoPeaje repo) {
        this.moduloIGestionClientes = new ModuloGestionClientes();

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
        log.infof("obtengo vehiculo" + vehiculo);
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


    private boolean  procesarVehiculoExtranjero(int tag,  Vehiculo vehiculo) {
        log.infof("*** Procesando pago vehículo extranjero %s tag:", tag);
        boolean habilitado = false;
        // Todos los vehículos extranjeros son preferenciales
        Preferencial tarifa = repo.obtenerTarifaPreferencial();

        if (tarifa != null) {
        log.infof("Tarifa obtenida %f ", tarifa.getMontoPreferencial());
        // Realizar el pre-pago

// Asignar vehículos si es necesario
// Asignar saldo, cuentas prepagas o postpagas si es necesario

//        ModuloGestionClientes.Dominio.ClienteTelepeaje cliente = new ModuloGestionClientes.Dominio.ClienteTelepeaje();
//        cliente.setCi("0000000");
//        cliente.setNombre("Extranjero");
//        ModuloGestionClientes.Dominio.Vehiculo vehiculo2 = new ModuloGestionClientes.Dominio.Vehiculo();
//        vehiculo2.setCliente(cliente);
//        String numeroTag = Integer.toString(tag);
//        ModuloGestionClientes.Dominio.Tag tag2 = new ModuloGestionClientes.Dominio.Tag(numeroTag);
//        vehiculo2.setTag(tag2);
//
//        cliente.getVehiculosCliente().add(vehiculo2);
//        cliente.setSaldo(tarifa.getMontoPreferencial());
//        ModuloGestionClientes.Dominio.PREPaga prePaga = new ModuloGestionClientes.Dominio.PREPaga();
//        prePaga.setSaldo(tarifa.getMontoPreferencial());
//        cliente.setCuentaPrepaga(prePaga);
//        moduloIGestionClientes.realizarPrePago( cliente, tarifa.getMontoPreferencial());

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
        return habilitado;
    }


//    private void mandarAQueueDePagos(Vehiculo vehiculo) {
//        //TODO esto lo vamos a hacer más adelante.
//    }

    private Vehiculo existeVehiculo(int tag, String matricula) {

        Vehiculo vehiculo = new Vehiculo();
        vehiculo = repo.BuscarTag(tag);

        if (vehiculo != null) {
            log.infof("Vehiculo encontrado con tag: %s", tag);
            return vehiculo;
        } else {
            vehiculo = repo.BuscarMatricula(matricula);
            if (vehiculo != null) {
                log.infof("Vehiculo encontrado con matricula: %s", tag);
            } else {
                //error grave el vehiculo no esta en el sistema
                String mensaje ="Vehiculo no encontrado: " + tag+ " " + matricula;
                if (this.vehiculoNoEncontrado != null) {
                    vehiculoNoEncontrado.fire(mensaje); // Invoca el método solo si vehiculoNoEncontrado no es nulo
                }

                        ;
            }
        }
        return vehiculo;
    }

    public void altaVehiculo(Vehiculo vehiculo){
        repo.altaVehiculo(vehiculo);
    }
    // Método para notificar el pasaje de vehículo al módulo de Monitoreo
    public void manejarNotificarPasajeVehiculo() {
        // Lógica para determinar el pasaje de vehículo
        // Una vez que se detecta el pasaje, se envía un evento para notificar al módulo de Monitoreo
        String mensaje = "Pasaje de vehículo detectado";
        eventoPasajeVehiculo.fire(mensaje);
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
