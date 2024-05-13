package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Dominio.*;

public interface RepoPeaje {


    public Vehiculo BuscarTag(int tag);

    Vehiculo BuscarMatricula(String matricula);

    double obtenerTarifaPreferencial();

    double obtenerTarifaComun();
}
