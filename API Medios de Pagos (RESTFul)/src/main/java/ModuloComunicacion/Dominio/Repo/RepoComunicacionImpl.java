package ModuloComunicacion.Dominio.Repo;
import ModuloComunicacion.Dominio.ClienteTelepeaje;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;


public class RepoComunicacionImpl implements RepoComunicacion {
    private Map<String, ClienteTelepeaje> clientesMap;
    public RepoComunicacionImpl() {
        clientesMap = new HashMap<>();
    }

    @Override
    public void altaDatosCliente(ModuloComunicacion.Dominio.ClienteTelepeaje cliente){
        String ci = cliente.getCi();
        clientesMap.put(ci, cliente);
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
