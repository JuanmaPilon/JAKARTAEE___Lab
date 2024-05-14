package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloGestionClientes.Dominio.Repo.RepoClientesImp;
import jakarta.enterprise.context.ApplicationScoped;

import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;

import jakarta.enterprise.event.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


// uso la inyeccion para inyectar el repoClientes,cualquier otra manera de usarlo ta mal
@ApplicationScoped
public class ModuloGestionClientes implements ModuloIGestionClientes {

    @Inject
    private Event<String> enventoPagoTarjeta;

    @Inject
    private Event<String> enventoPREPago;

    @Inject
    private RepoClientes repoClientes;

    public ModuloGestionClientes() {
        this.repoClientes = new RepoClientesImp();
    }

    @Override
    public void altaClienteTeleapeje(Usuario usuario) {
        // Verificar si el cliente ya existe
        ClienteTelepeaje clienteExistente = repoClientes.buscarClienteTelePorCI(usuario.getCi());
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


    @Override
    public void cargarSaldo(ClienteTelepeaje cliente, Double importe) {
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.cargarSaldo(importe);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("El saldo ha sido cargado exitosamente para el cliente: " + cliente.getCi());
        } else {
            System.out.println("Cliente no encontrado en el repositorio.");
        }
    }

    @Override
    public void cargarSaldo(ClienteSucive cliente, Double importe) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.cargarSaldo(importe);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("El saldo ha sido cargado exitosamente para el cliente: " + cliente.getCi());
        } else {
            System.out.println("Cliente no encontrado en el repositorio.");
        }
    }

    @Override
    public void vincularVehiculo(ClienteSucive cliente, Vehiculo vehiculo) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
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
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
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
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());

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
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());

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
   public void altaClienteSucksive(Usuario usuario){
       // Verificar si el cliente ya existe
       ClienteSucive clienteExistente = repoClientes.buscarClienteSucPorCI(usuario.getCi());
       if (clienteExistente == null) {
           // Crear una nueva lista de vehículos para el cliente (puedes inicializarla vacía si no tienes vehículos para agregar aquí)
           List<Vehiculo> vehiculosCliente = new ArrayList<>();
           // Crear una nueva instancia de ClienteTelepeaje con todos los parámetros requeridos
           ClienteTelepeaje nuevoCliente = new ClienteTelepeaje(usuario.getNom(), usuario.getCi(), usuario.getEmail(), vehiculosCliente);
           // Agregar el nuevo cliente al repositorio
           repoClientes.agregarClienteTelepeaje(nuevoCliente);
           System.out.println("Alta Cliente Sucive para el usuario: " + usuario.getCi());
       } else {
           // Si el cliente ya existe, mostrar un mensaje de error
           System.out.println("El usuario ya esta registrado como cliente de Telepeaje.");
       }
   }

    @Override
    public Set<Object> obtenerCuentasPorTag(ClienteTelepeaje cliente, Tag tag) {
        Set<Object> cuentasPorTag = new HashSet<>();
        for (Vehiculo vehiculo : cliente.getVehiculosCliente()) {
            if (vehiculo.getTag().equals(tag)) {
                if (cliente.getCuentaPrepaga() != null) {
                    cuentasPorTag.add(cliente.getCuentaPrepaga());
                }
                if (cliente.getCuentaPostpaga() != null) {
                    cuentasPorTag.add(cliente.getCuentaPostpaga());
                }
            }
        }
        return cuentasPorTag;
    }

    @Override
    public void realizarPrePago(ClienteTelepeaje cliente, double importe) {
        PREPaga cuenta = cliente.getCuentaPrepaga();
        if (cuenta != null) {
            if (cuenta.getSaldo() >= importe) {
                cuenta.setSaldo(cuenta.getSaldo() - importe);
                System.out.println("Pago realizado. Saldo restante: " + cuenta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente.");
                String mensajeTarjeta = "Saldo insuficiente";
                enventoPREPago.fire(mensajeTarjeta);
            }
        } else {
            System.out.println("No hay cuenta PREPaga asignada.");
        }
    }

    @Override
    public void realizarPostPago(ClienteTelepeaje cliente, double importe) {
        POSTPaga cuenta = cliente.getCuentaPostpaga();
        if (cuenta != null) {
            Tarjeta tarjeta = cuenta.getTarjeta();
            if (tarjeta != null) {
                System.out.println("Pago de " + importe + " realizado con tarjeta: " + tarjeta.getNroTarjeta());
                String mensajeTarjeta = "Pago realizado con Tarjeta: " + "Importe: " + importe + " realizado con tarjeta: " + tarjeta.getNroTarjeta();
                enventoPagoTarjeta.fire(mensajeTarjeta);
            } else {
                System.out.println("No hay tarjeta asociada a la cuenta POSTPaga.");
                String mensajeTarjeta = "Tarjeta: Rechazada";
                enventoPagoTarjeta.fire(mensajeTarjeta);
            }
        } else {
            System.out.println("No hay cuenta POSTPaga asignada.");
        }
    }
}


