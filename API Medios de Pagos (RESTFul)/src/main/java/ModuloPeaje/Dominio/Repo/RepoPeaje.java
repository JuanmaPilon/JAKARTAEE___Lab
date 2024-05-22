package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Dominio.*;

public interface RepoPeaje {

    public void altaVehiculo(Vehiculo vehiculo);
    public Vehiculo BuscarTag(int tag);

    Vehiculo BuscarMatricula(String matricula);

    Preferencial obtenerTarifaPreferencial();

    double obtenerTarifaComun();
}
