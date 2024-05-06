package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.Usuario;

public interface GestionClientesService {
    void altaClienteTeleapeje(Usuario usuario);
    Usuario crearUsuarioExtranjero(String ci, String nombre, String email);
    Usuario crearUsuarioNacional(String ci, String nombre, String email);
}