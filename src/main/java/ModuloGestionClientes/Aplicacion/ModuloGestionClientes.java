package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import jakarta.enterprise.context.ApplicationScoped;

import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


// uso la inyeccion para inyectar el repoClientes,cualquier otra manera de usarlo ta mal
@ApplicationScoped
public class ModuloGestionClientes implements ModuloIGestionClientes {

    @Inject
    private RepoClientes repoClientes;

    private List<Usuario> usuario = new ArrayList<>();

    @Override
    public void altaClienteTeleapeje(Usuario usuario) {
        // Verificar si el cliente ya existe
        ClienteTelepeaje clienteExistente = repoClientes.buscarClientePorCI(usuario.getCi());
        if (clienteExistente == null) {
            // Crear una nueva lista de vehículos para el cliente (puedes inicializarla vacía si no tienes vehículos para agregar aquí)
            List<Vehiculo> vehiculosCliente = new ArrayList<>();
            // Crear una nueva instancia de ClienteTelepeaje con todos los parámetros requeridos
            ClienteTelepeaje nuevoCliente = new ClienteTelepeaje(usuario.getNom(), usuario.getCi(), usuario.getEmail(), vehiculosCliente);
            // Agregar el nuevo cliente al repositorio
            repoClientes.agregarClienteTelepeaje(nuevoCliente);
            System.out.println("Alta Cliente Telepeaje para el usuario: " + usuario.getCi());
        } else {
            // Si el cliente ya existe, mostrar un mensaje de error
            System.out.println("El usuario ya esta registrado como cliente de Telepeaje.");
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
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClientePorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.agregarVehiculoACliente(vehiculo);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("El veheiculo ha sido vinculado al cliente exitosamente.");
        } else {
            System.out.println("Cliente no encontrado en el repo.");
        }
    }

    @Override
    public void vincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo) {
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClientePorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.agregarVehiculoACliente(vehiculo);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("El veheiculo ha sido vinculado al cliente exitosamente.");
        } else {
            System.out.println("Cliente no encontrado en el repo.");
        }
    }

    @Override
    public void desvincularVehiculo(ClienteTelepeaje cliente, Vehiculo vehiculo) {
        // Buscar el cliente en el repositorio
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClientePorCI(cliente.getCi());

        // verifica si el cliente existe en el repositorio
        if (clienteEnRepo != null) {
            // obtiene los vehiculos vinculados al cliente
            List<Vehiculo> vehículosVinculados = clienteEnRepo.getVehiculosCliente();

            // Verificar si el vehículo está vinculado al cliente
            if (vehículosVinculados.contains(vehiculo)) {
                // Desvincular el vehículo del cliente
                vehículosVinculados.remove(vehiculo);

                // actualizar
                repoClientes.actualizarCliente(clienteEnRepo);

                System.out.println("El vechiculo ha sido desvinculado del cliente exitosamente.");
            } else {
                System.out.println("El vehiculo no ta vinculado al cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado en el repositorio.");
        }
    }

    @Override
    public void desvincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucivePorCI(cliente.getCi());

        if (clienteEnRepo != null) {
            List<Vehiculo> vehiculosVinculados = clienteEnRepo.getVehiculosCliente();

            if (vehiculosVinculados.contains(vehiculo)) {
                vehiculosVinculados.remove(vehiculo);
                repoClientes.actualizarCliente(clienteEnRepo);
                System.out.println("El vechiculo ha sido desvinculado del cliente exitosamente.");
            } else {
                System.out.println("El vechiculo no está vinculado al cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado en el repositorio.");
        }
    }
}

//    @Override
//      public Set<Cuenta> obtenerCuentasPorTag(ClienteTelepeaje cliente, Tag tag) {
//        //return cliente.obtenerCuentasPorTag(tag);
//          return null;
//      }

//    @Override
//    public void realizarPrePago(ClienteTelepeaje cliente, double importe) {
//        // Implementación de realizarPrePago
//    }

//    @Override
//    public void realizarPostPago(ClienteTelepeaje cliente, double importe) {
//        // Implementación de realizarPostPago
//    }


