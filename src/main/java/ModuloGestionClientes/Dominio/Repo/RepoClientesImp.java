package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import jakarta.inject.Inject;
import ModuloGestionClientes.Dominio.Repo.RepoClientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class RepoClientesImp implements RepoClientes {

    // Usaremos un mapa para simular el repositorio de clientes en memoria
    private Map<String, ClienteTelepeaje> clientesTelepeajeMap;

    public RepoClientesImp() {
        clientesTelepeajeMap = new HashMap<>();
    }

    @Override
    public void agregarClienteTelepeaje(ClienteTelepeaje cliente) {
        clientesTelepeajeMap.put(cliente.getCi(), cliente);
    }

    @Override
    public ClienteTelepeaje buscarClientePorCI(String ci) {
        return clientesTelepeajeMap.get(ci);
    }

    @Override
    public void actualizarCliente(ClienteTelepeaje cliente) {
        clientesTelepeajeMap.put(cliente.getCi(), cliente);
    }

    @Override
    public void eliminarClientePorCI(String ci) {
        clientesTelepeajeMap.remove(ci);
    }

}
