package ModuloComunicacion.Dominio.Repo;
import java.util.HashMap;
import java.util.Map;

import ModuloGestionClientes.Dominio.*;


public class RepoComunicacionImpl implements RepoComunicacion {
    private Map<String, String> clientesMap;
    public RepoComunicacionImpl() {
        clientesMap = new HashMap<>();
    }

    @Override
    public void altaDatosCliente(ModuloComunicacion.Dominio.ClienteTelepeaje cliente, String email){
        clientesMap.put(cliente.getCi(), email);
    }
    @Override
    public String buscarMailCliente(String ci) {
        return clientesMap.get(ci);
    }

}
