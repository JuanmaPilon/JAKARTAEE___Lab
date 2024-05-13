package ModuloPeaje.Aplicacion;
import ModuloPeaje.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.Getter;
import ModuloPeaje.Dominio.Repo.RepoPeaje;


@ApplicationScoped
public class ModuloPeajeImpl {
    @Inject
    private Event<String> eventoPasajeVehiculo; // Evento CDI para notificar el pasaje de vehículo al módulo de Monitoreo


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


    // Método para notificar el pasaje de vehículo al módulo de Monitoreo
    public void manejarNotificarPasajeVehiculo() {
        // Lógica para determinar el pasaje de vehículo
        // Una vez que se detecta el pasaje, se envía un evento para notificar al módulo de Monitoreo
        String mensaje = "Pasaje de vehículo detectado";
        eventoPasajeVehiculo.fire(mensaje);
    }

    public boolean estaHabilitado(Identificador identificador) {
        return identificador instanceof Tag || identificador instanceof Matricula;
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


    public void actualizarTarifaPreferencial(double importe) {
        // Obtiene la tarifa preferencial actual
         importe = repo.obtenerTarifaPreferencial();

        // Actualiza el importe de la tarifa preferencial con el importe proporcionado
        this.tarifaPreferencial.setMonto(importe);

        //Validación o procesamiento futuro
    }

}
