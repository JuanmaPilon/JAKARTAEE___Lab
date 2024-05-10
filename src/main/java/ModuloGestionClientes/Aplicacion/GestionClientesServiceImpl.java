package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloMediosPago.Dominio.UsrExtranjero;
import jakarta.enterprise.context.ApplicationScoped;
import ModuloGestionClientes.Dominio.Repo.RepoClientes;

import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


// uso la inyeccion para inyectar el repoClientes,cualquier otra manera de usarlo ta mal
@ApplicationScoped
public class GestionClientesServiceImpl implements GestionClientesService {

    @Inject
    private RepoClientes repoClientes;

    private List<Usuario> usuario = new ArrayList<>();

    @Override
    public void altaClienteTeleapeje(Usuario usuario) {
        // como el profe dijo para verificar si ya existe y demas
        ClienteTelepeaje clienteExistente = repoClientes.buscarClientePorCI(usuario.getCi());
        if (clienteExistente == null) {
            ClienteTelepeaje nuevoCliente = new ClienteTelepeaje(usuario.getNom(), usuario.getCi());
            repoClientes.agregarClienteTelepeaje(nuevoCliente);
            System.out.println("Alta Cliente Telepeaje para el usuario: " + usuario.getCi());
        } else {
            System.out.println("El usuario ya ta registrado como cliente de Telepeaje.");
        }
    }

    // Método para crear un usuario extranjero
    @Override
    public Usuario crearUsuarioExtranjero(String ci, String nombre, String email) {
        return new UsrNacional(ci, nombre, email);
    }

    // Método para crear un usuario nacional
    @Override
    public Usuario crearUsuarioNacional(String ci, String nombre, String email) {
        return new UsrNacional(ci, nombre, email);
    }
    @Override
    public void cargarSaldo(ClienteTelepeaje cliente, Double importe) {
        //conveniendo que tengamos cargarSAldo
        //   cliente.cargarSaldo(importe);
    }
    @Override
    public void cargarSaldo(ClienteSucive cliente, Double importe) {
        //conveniendo que tengamos cargarSAldo
        // cliente.cargarSaldo(importe);
    }

    @Override
        public void vincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo) {

            //cliente.vincularVehiculo(vehiculo);
        }

    @Override
    public void vincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo) {

        //cliente.vincularVehiculo(vehiculo);
    }

    @Override
    public void desvincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo) {
           // cliente.desvincularVehiculo(vehiculo);
        }

    @Override
    public void desvincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo) {
        // cliente.desvincularVehiculo(vehiculo);
    }

    @Inject
    private RepoClientes repoClientes; // Repositorio de clientes

    @Override
    public Set<Vehiculo> mostraVehículosVinculados(Cliente cliente) {
        Cliente clienteEnRepo = repoClientes.buscarClientePorId(cliente.getId());
        if (clienteEnRepo != null) {

            return clienteEnRepo.getVehiculos();
        } else {
            // Si el cliente no se encuentra en el repositorio, devolver un conjunto vacío
            return new HashSet<>();
        }
    }
}