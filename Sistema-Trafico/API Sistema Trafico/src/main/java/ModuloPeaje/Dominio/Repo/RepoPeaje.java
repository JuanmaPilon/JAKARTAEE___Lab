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

    public void altaTag(Tag tag);
    public void bajaTag(long id);
    public void modificarTag(Tag tag);

    public void altaMatricula(Matricula matricula);
    public void bajaMatricula(String id);
    public void modificarMatricula(Matricula matricula);

    public void altaPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje);
    public void bajaPasadaPorPeaje(long id);
    public void modificarPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje);




}
