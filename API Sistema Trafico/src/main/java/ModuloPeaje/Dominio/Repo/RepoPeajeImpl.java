package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Dominio.*;

import java.util.*;

import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class RepoPeajeImpl implements RepoPeaje {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    private Preferencial tarifaPreferencial;
    private Comun tarifaComun;
    private List<Vehiculo> vehiculos;


//    public RepoPeajeImpl(Preferencial tarifaPreferencial, Comun tarifaComun) {
//        this.tarifaPreferencial = tarifaPreferencial;
//        this.tarifaComun = tarifaComun;
//        this.vehiculos = new ArrayList<>();
//
//    }
    @Override
    public void altaVehiculo(Vehiculo vehiculo) {

        this.vehiculos.add(vehiculo);

    }


    @Override
    public Vehiculo BuscarTag(int tag) {
        log.infof("b  "+ tag);
        for (Vehiculo vehiculo : vehiculos) {
            if (Integer.parseInt(vehiculo.getTag().getIdUnico()) == tag) {
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public Vehiculo BuscarMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Nacional nacional) {
                if (nacional.getMatricula().getNroMatricula().equals(matricula)) {
                    return nacional;
                }
            }
        }
        return null; // Vehículo no encontrado
    }
    @Override
    public Preferencial obtenerTarifaPreferencial() {
        return tarifaPreferencial;
    }

    @Override
    public double obtenerTarifaComun() {
        return tarifaComun.obtenerMonto();
    }


}
