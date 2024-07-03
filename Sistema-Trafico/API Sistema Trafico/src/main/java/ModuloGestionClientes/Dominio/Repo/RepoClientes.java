package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.*;

import java.util.Date;
import java.util.List;

public interface RepoClientes {
    void agregarClienteTelepeaje(ClienteTelepeaje cliente);
    ClienteTelepeaje buscarClienteTelePorCI(String ci);
    void actualizarCliente(ClienteTelepeaje cliente);
    void eliminarClientePorCI(String ci);
    void agregarClienteSucive(ClienteSucive cliente);
    void actualizarCliente(ClienteSucive cliente);
    void eliminarClienteSucivePorCI(String ci);
    void agregarClienteSukcsive(ClienteSucive cliente);
    ClienteSucive buscarClienteSucPorCI(String ci);

    void addVehiculo(Vehiculo vehiculo);
    Vehiculo BuscarTag(String tag);

    void altaMatricula(Matricula matricula);
    void bajaMatricula(long id);
    void modificarMatricula(Matricula matricula);

    void altaPasadaPorPeaje(double monto,Date fecha, Long idvehiculo) ;
    void bajaPasadaPorPeaje(long id);
    void modificarPasadaPorPeaje(PasadaPorPeaje pasadaPorPeaje);

    void altaTag(Tag tag);
    void bajaTag(long id);
    void ModificarTag(Tag tag);

    void altaVehiculo(Vehiculo vehiculo);
    void bajaVehiculo(Long id);
    void modificarVehiculo(Vehiculo vehiculo);

    List<PasadaPorPeaje> buscarPasadaPorPeaje(Vehiculo vehiculo, Date fechaInicio, Date fechaFin);
    void actualizarCuentaPrepaga(PREPaga cuenta);
    void actualizarCuentaPostpaga(POSTPaga cuenta);
}