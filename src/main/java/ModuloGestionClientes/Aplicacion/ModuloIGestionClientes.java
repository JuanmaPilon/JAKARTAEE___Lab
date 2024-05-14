package ModuloGestionClientes.Aplicacion;
import java.util.Set;
import ModuloGestionClientes.Dominio.*;

public interface ModuloIGestionClientes {
    void altaClienteTeleapeje(Usuario usuario);
    void cargarSaldo(ClienteSucive cliente, Double importe);
    void cargarSaldo(ClienteTelepeaje cliente, Double importe);
    Usuario crearUsuarioExtranjero(String ci, String nombre, String email);
    Usuario crearUsuarioNacional(String ci, String nombre, String email);
    void vincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo);
    void vincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo);
    void desvincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo);
    void desvincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo);
   // Set<Cuenta> obtenerCuentasPorTag(ClienteTelepeaje cliente, Tag tag);
   // void realizarPrePago(ClienteTelepeaje cliente, double importe);
   // void realizarPostPago(ClienteTelepeaje cliente, double importe);

}