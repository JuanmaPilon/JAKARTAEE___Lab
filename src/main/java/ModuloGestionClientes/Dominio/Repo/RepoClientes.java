package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.*;

public interface RepoClientes {
    void agregarClienteTelepeaje(ClienteTelepeaje cliente);
    ClienteTelepeaje buscarClientePorCI(String ci);
    void actualizarCliente(ClienteTelepeaje cliente);
    void eliminarClientePorCI(String ci);
}
