package ModuloMediosPago.Dominio.Repo;

import ModuloMediosPago.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepoMediosPagoImpl implements RepoMediosPago{
    private Map<String, ClienteTelepeaje> clientesMap;
    public RepoMediosPagoImpl() {
        clientesMap = new HashMap<>();
    }

    @Override
    public void altaDatosCliente(ModuloMediosPago.Dominio.ClienteTelepeaje cliente){
        clientesMap.put(cliente.getCi(), cliente);
    }
    @Override
    public ClienteTelepeaje buscarCliente(String ci) {
        return clientesMap.get(ci);
    }
    @Override
    public Collection<ClienteTelepeaje> obtenerTodosLosClientes() {
        return clientesMap.values(); //retorna una coleccion de clientes
    }

}
