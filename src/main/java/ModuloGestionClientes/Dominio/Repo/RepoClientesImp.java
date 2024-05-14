package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import ModuloGestionClientes.Dominio.ClienteSucive;
import ModuloGestionClientes.Dominio.Usuario;
import ModuloGestionClientes.Dominio.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepoClientesImp implements RepoClientes {
    private Map<String, ClienteTelepeaje> clientesTelepeajeMap;
    private Map<String, ClienteSucive> clientesSuciveMap;


    public RepoClientesImp() {
        clientesTelepeajeMap = new HashMap<>();
        clientesSuciveMap = new HashMap<>();
    }


    @Override
    public void agregarClienteTelepeaje(ClienteTelepeaje cliente) {
        clientesTelepeajeMap.put(cliente.getCi(), cliente);
    }

    @Override
    public void agregarClienteSukcsive(ClienteSucive cliente) {
        clientesSuciveMap.put(cliente.getCi(), cliente);
    }

    @Override
    public ClienteTelepeaje buscarClienteTelePorCI(String ci) {
        return clientesTelepeajeMap.get(ci);
    }

    @Override
    public ClienteSucive buscarClienteSucPorCI(String ci) {
        return clientesSuciveMap.get(ci);
    }

    @Override
    public void actualizarCliente(ClienteTelepeaje cliente) {
        clientesTelepeajeMap.put(cliente.getCi(), cliente);
    }

    @Override
    public void eliminarClientePorCI(String ci) {
        clientesTelepeajeMap.remove(ci);
    }

    @Override
    public void agregarClienteSucive(ClienteSucive cliente) {
        clientesSuciveMap.put(cliente.getCi(), cliente);
    }

    @Override
    public void actualizarCliente(ClienteSucive cliente) {
        clientesSuciveMap.put(cliente.getCi(), cliente);
    }

    @Override
    public void eliminarClienteSucivePorCI(String ci) {
        clientesSuciveMap.remove(ci);
    }


}
