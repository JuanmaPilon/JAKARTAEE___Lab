package ModuloGestionClientes.Dominio.Repo;

import ModuloGestionClientes.Dominio.ClienteTelepeaje;
import ModuloGestionClientes.Dominio.ClienteSucive;
import ModuloGestionClientes.Dominio.Usuario;
import ModuloGestionClientes.Dominio.Vehiculo;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class RepoClientesImp implements RepoClientes {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    private Map<String, ClienteTelepeaje> clientesTelepeajeMap;
    private Map<String, ClienteSucive> clientesSuciveMap;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public RepoClientesImp() {

        clientesTelepeajeMap = new HashMap<>();
        clientesSuciveMap = new HashMap<>();
        this.vehiculos = new ArrayList<>();

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

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public Vehiculo BuscarTag(int tag) {
        for (Vehiculo vehiculo : vehiculos) {
            int tag2 = Integer.parseInt(vehiculo.getTag().getIdUnico());
            if (tag2 == tag) {
                return vehiculo;
            }
        }
        return null;
    }

}

