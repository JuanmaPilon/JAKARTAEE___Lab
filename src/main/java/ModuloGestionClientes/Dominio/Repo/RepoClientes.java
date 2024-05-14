package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.*;

public interface RepoClientes {
    void agregarClienteTelepeaje(ClienteTelepeaje cliente);
    ClienteTelepeaje buscarClientePorCI(String ci);
    void actualizarCliente(ClienteTelepeaje cliente);
    void eliminarClientePorCI(String ci);
    void agregarClienteSucive(ClienteSucive cliente);
    ClienteSucive buscarClienteSucivePorCI(String ci);
    void actualizarCliente(ClienteSucive cliente);
    void eliminarClienteSucivePorCI(String ci);

}
