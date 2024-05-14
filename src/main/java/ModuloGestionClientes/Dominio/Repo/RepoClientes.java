package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.*;

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

}
