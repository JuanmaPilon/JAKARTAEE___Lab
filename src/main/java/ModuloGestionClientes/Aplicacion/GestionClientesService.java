package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.*;

public interface GestionClientesService {
    void altaClienteTeleapeje(Usuario usuario);
    void cargarSaldo(ClienteSucive cliente, Double importe);
    void cargarSaldo(ClienteTelepeaje cliente, Double importe);
    Usuario crearUsuarioExtranjero(String ci, String nombre, String email);
    Usuario crearUsuarioNacional(String ci, String nombre, String email);
    void vincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo);
    void vincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo);
}