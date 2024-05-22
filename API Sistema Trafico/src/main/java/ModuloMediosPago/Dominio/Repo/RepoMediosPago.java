package ModuloMediosPago.Dominio.Repo;

import ModuloMediosPago.Dominio.*;

import java.util.Collection;

public interface RepoMediosPago {
    void altaDatosCliente(ClienteTelepeaje cliente);
    ClienteTelepeaje buscarCliente(String ci);
    Collection<ClienteTelepeaje> obtenerTodosLosClientes();
}
