package ModuloGestionClientes.Aplicacion;
import java.util.Set;
import ModuloGestionClientes.Dominio.*;
import java.util.Date;

public interface ModuloIGestionClientes {
    void altaClienteTeleapeje(Usuario usuario);
    void cargarSaldo(ClienteSucive cliente, Double importe);
    void cargarSaldo(ClienteTelepeaje cliente, Double importe);

    void vincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo);
    void vincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo);
    void desvincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo);
    void desvincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo);
    Set<Object> obtenerCuentasPorTag(ClienteTelepeaje cliente, Tag tag);
    boolean realizarPrePago(String tag, double importe);
    boolean realizarPostPago(String tag, double importe);
    void altaClienteSucksive(Usuario usuario);
    Double consultarSaldo(ClienteSucive cliente);
    Double consultarSaldo(ClienteTelepeaje cliente);
    void asociarTarjeta(ClienteTelepeaje clienteTelepeaje ,Tarjeta tarjeta);
    void asociarTarjeta(ClienteSucive clienteSucive, Tarjeta tarjeta);
    //Set<PasadaPorPeaje> consultarPasadas(ClienteTelepeaje cliente, Date fechaInicio, Date fechaFin);
    Set<PasadaPorPeaje> consultarPasadas(ClienteSucive cliente, Date fechaInicio, Date fechaFin);
    Set<PasadaPorPeaje> consultarPasadas(ClienteTelepeaje cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFin);
    Set<PasadaPorPeaje> consultarPasadas(ClienteSucive cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFin);

}