package ModuloPeaje.Dominio.Repo;

import java.util.Collection;
import ModuloPeaje.Dominio.*;
import java.util.Collection;

public interface RepoPeaje {


    public Vehiculo BuscarTag(int tag);

    Vehiculo BuscarMatricula(String matricula);

    Preferencial obtenerTarifaPreferencial();

    Comun obtenerTarifaComun();
}
