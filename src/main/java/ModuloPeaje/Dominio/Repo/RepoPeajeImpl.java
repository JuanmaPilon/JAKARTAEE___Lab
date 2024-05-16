package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Dominio.*;


public class RepoPeajeImpl implements RepoPeaje {

    private Preferencial tarifaPreferencial;
    private Comun tarifaComun;

    public RepoPeajeImpl(Preferencial tarifaPreferencial, Comun tarifaComun) {
        this.tarifaPreferencial = tarifaPreferencial;
        this.tarifaComun = tarifaComun;
    }

    @Override
    public Vehiculo BuscarTag(int tag) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTag().equals(tag)) {
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public Vehiculo BuscarMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Nacional) {
                Nacional nacional = (Nacional) vehiculo;
                if (nacional.getMatricula().getNroMatricula().equals(matricula)) {
                    return nacional;
                }
            }
        }
        return null; // Vehículo no encontrado
    }
    @Override
    public Preferencial obtenerTarifaPreferencial() {
        return null;
    }

    @Override
    public double obtenerTarifaComun() {
        return tarifaComun.obtenerMonto();
    }
}
