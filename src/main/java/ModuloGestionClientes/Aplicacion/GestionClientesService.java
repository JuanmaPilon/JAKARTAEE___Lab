package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.*;

public interface GestionClientesService {
    public void altaClienteTeleapeje(Usuario usuario);
    public void cargarSaldo(ClienteSucive cliente, Double importe);
    public void cargarSaldo(ClienteTelepeaje cliente, Double importe);
    Usuario crearUsuarioExtranjero(String ci, String nombre, String email);
    Usuario crearUsuarioNacional(String ci, String nombre, String email);
}