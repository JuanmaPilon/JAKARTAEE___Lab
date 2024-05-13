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
        // Lógica para buscar un vehículo por tag
        return null;
    }

    @Override
    public Vehiculo BuscarMatricula(String matricula) {
        // Lógica para buscar un vehículo por matrícula
        return null;
    }

    @Override
    public double obtenerTarifaPreferencial() {
        return tarifaPreferencial.obtenerMonto();
    }

    @Override
    public double obtenerTarifaComun() {
        return tarifaComun.obtenerMonto();
    }
}
