package ModuloPeaje.Dominio.Repo;

import ModuloPeaje.Dominio.*;

public interface RepoPeaje {

    public Vehiculo BuscarTag(int tag);

    Vehiculo BuscarMatricula(String matricula);

    Preferencial obtenerTarifaPreferencial();

    double obtenerTarifaComun();
    // -------------- CRUDs de Persistencia:
    public void altaVehiculo(Vehiculo vehiculo);
    public void bajaVehiculo(Long id);
    public void modificarVehiculo(Vehiculo vehiculo);

    public void altaVehiculoNacional(Nacional vehiculoNacional);
    public void bajaVehiculoNacional(long id);
    public void modificarVehiculoNacional(Nacional vehiculoNacional);

    public void altaVehiculoExtranjero(Extranjero vehiculoExtranjero);
    public void bajaVehiculoExtranjero(long id);
    public void modificarVehiculoExtranjero(Extranjero vehiculoExtranjero);

}
