package ModuloGestionClientes.Aplicacion;

import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloGestionClientes.Dominio.Repo.RepoClientesImp;
import ModuloGestionClientes.Evento.PublicadorEventoClientes;
import ModuloMediosPago.Interface.api.MediosPagoImpl;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import jakarta.enterprise.context.ApplicationScoped;

import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;

import jakarta.enterprise.event.Event;
import org.jboss.logging.Logger;
import org.tallerjava.ClienteTelepeajeDTO;
import org.tallerjava.TarjetaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;


// uso la inyeccion para inyectar el repoClientes,cualquier otra manera de usarlo ta mal
@ApplicationScoped
public class ModuloGestionClientes implements ModuloIGestionClientes {
    private static final Logger log = Logger.getLogger(ModuloPeajeImpl.class);
    @Inject
    private ModuloIGestionClientes ModuloIGestionClientes;
    // -----------------------------------------------------
    @Inject
    private PublicadorEventoClientes pagoTarjeta;

    @Inject
    private PublicadorEventoClientes pagoDebito;
    // ------------------------------------------------------
    @Inject
    private RepoClientes repoClientes;

    @Inject
    private MediosPagoImpl pagosExternos;


    public ModuloGestionClientes() {
        this.repoClientes = new RepoClientesImp();
        this.pagosExternos = new MediosPagoImpl();
    }
    public ModuloGestionClientes(RepoClientesImp repoClientesImp) {
        this.pagosExternos = new MediosPagoImpl();
        this.repoClientes = repoClientesImp;
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
            System.out.println("El vehiculo ha sido vinculado al cliente exitosamente.");
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

    public void altaClienteSucksive(Usuario usuario) {
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
    public boolean realizarPrePago(String tag, double importe) {
        Vehiculo vehiculo = repoClientes.BuscarTag(tag);
        System.out.println("-----------------------------------------vehiculo ------------------------------------"+vehiculo.toString());
        PREPaga cuenta =  vehiculo.getClienteTelepeaje().getCuentaPrepaga();

        if (cuenta != null) {
            if (cuenta.getSaldo() >= importe) {
                cuenta.setSaldo(cuenta.getSaldo() - importe);
                System.out.println("Pago realizado. Saldo restante: " + cuenta.getSaldo());
                String mensajeTarjeta = "Genero el pago";
                if (this.pagoDebito != null) {
                    pagoDebito.publicarPrePago(mensajeTarjeta);
                }
                return true;
            } else {
                if(this.pagoDebito != null) {
                    System.out.println("Saldo insuficiente.");


                }
                return false;
            }
        } else {
            System.out.println("No hay cuenta PREPaga asignada.");
            return false;
        }
    }

    @Override
    public boolean realizarPostPago(String tag, double importe) {
        Vehiculo vehiculo = repoClientes. BuscarTag(tag);
        POSTPaga cuenta = vehiculo.getClienteTelepeaje().getCuentaPostpaga();
        if (cuenta != null) {
            if (cuenta.getSaldo() >= importe) {
                Tarjeta tarjeta = cuenta.getTarjeta();
                if (tarjeta != null) {
                    System.out.println("Pago de " + importe + " realizado con tarjeta: " + tarjeta.getNroTarjeta());
                    ClienteTelepeajeDTO clienteDTO = new ClienteTelepeajeDTO(vehiculo.getClienteTelepeaje().getNombre(), vehiculo.getClienteTelepeaje().getCi(), vehiculo.getClienteTelepeaje().getEmail(), new ArrayList<>());
                    TarjetaDTO tarjetaDTO = new TarjetaDTO(tarjeta.getNroTarjeta(), tarjeta.getNombre(), tarjeta.getFechaVto());
                    pagosExternos.CobroTelepeaje(clienteDTO, tarjetaDTO);
                    if (this.pagoTarjeta != null) {
                        String mensajeTarjeta = "Pago realizado con Tarjeta: " + "Importe: " + importe + " realizado con tarjeta: " + tarjeta.getNroTarjeta();
                        pagoTarjeta.publicarPostPago(mensajeTarjeta);
                    }
                    return true;

                } else {
                    System.out.println("No hay tarjeta asociada a la cuenta POSTPaga.");
                    if (this.pagoTarjeta != null) {
                        String mensajeTarjeta = "Tarjeta: Rechazada";
                        pagoDebito.publicarPrePago(mensajeTarjeta);
                    }
                    return false;
                }
            } else {
                System.out.println("No hay saldo");
                return false;
            }
        } else {
            System.out.println("No hay cuenta POSTPaga asignada.");
            return false;
        }
    }

    @Override
    public Double consultarSaldo(ClienteSucive cliente) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            return clienteEnRepo.consultarSaldo();
        } else {
            System.out.println("Cliente no encontrado en el repo.");
            return null;
        }
    }

    @Override
    public Double consultarSaldo(ClienteTelepeaje cliente) {
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            return clienteEnRepo.consultarSaldo();
        } else {
            System.out.println("Cliente no encontrado en el repo.");
            return null;
        }
    }

    @Override
    public void asociarTarjeta(ClienteTelepeaje cliente, Tarjeta tarjeta) {
        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.asociarTarjeta(tarjeta);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("La tarjeta ha sido asociada esitosamente al cliente: " + cliente.getCi());
        } else {
            System.out.println("Cliente no encontrado en el repo");
        }
    }

    @Override
    public void asociarTarjeta(ClienteSucive cliente, Tarjeta tarjeta) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            clienteEnRepo.asociarTarjeta(tarjeta);
            repoClientes.actualizarCliente(clienteEnRepo);
            System.out.println("La tarjeta ha sido asociada esitosamente al cliente: " + cliente.getCi());
        } else {
            System.out.println("Cliente no encontrado en el repo");
        }
    }

//    @Override
//    public Set<PasadaPorPeaje> consultarPasadas(ClienteTelepeaje cliente, Date fechaInicio, Date fechaFin) {
//        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
//        if (clienteEnRepo != null) {
//            List<PasadaPorPeaje> pasadasEnRango = clienteEnRepo.getPasadasEnRango(fechaInicio, fechaFin);
//            return new HashSet<>(pasadasEnRango);
//        } else {
//            System.out.println("Cliente no encontrado en el repo.");
//            return new HashSet<>();
//        }
//    }

    @Override
    public Set<PasadaPorPeaje> consultarPasadas(ClienteSucive cliente, Date fechaInicio, Date fechaFin) {
        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
        if (clienteEnRepo != null) {
            List<PasadaPorPeaje> pasadasEnRango = clienteEnRepo.getPasadasEnRango(fechaInicio, fechaFin);
            return new HashSet<>(pasadasEnRango);
        } else {
            System.out.println("Cliente no encontrado en el repo");
            return new HashSet<>();
        }
    }


//    @Override
//    public Set<PasadaPorPeaje> consultarPasadas(ClienteSucive cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFin) {
//        ClienteSucive clienteEnRepo = repoClientes.buscarClienteSucPorCI(cliente.getCi());
//        if (clienteEnRepo != null) {
//            if (clienteEnRepo.getVehiculosCliente().contains(vehiculo)) {
//                Set<PasadaPorPeaje> pasadasEnRango = new HashSet<>();
//                for (PasadaPorPeaje pasada : vehiculo.getPasadaPorPeajeList()) {
//                    if (!pasada.getFecha().before(fechaInicio) && !pasada.getFecha().after(fechaFin)) {
//                        pasadasEnRango.add(pasada);
//                    }
//                }
//                return pasadasEnRango;
//            } else {
//                System.out.println("El vehiculo no esta vinculado al cliente");
//                return new HashSet<>();
//            }
//        } else {
//            System.out.println("Cliente no encontrado en el repo");
//            return new HashSet<>();
//        }
//    }
//
//    @Override
//    public Set<PasadaPorPeaje> consultarPasadas(ClienteTelepeaje cliente, Vehiculo vehiculo, Date fechaInicio, Date fechaFin) {
//        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI(cliente.getCi());
//        if (clienteEnRepo != null) {
//            if (clienteEnRepo.getVehiculosCliente().contains(vehiculo)) {
//                Set<PasadaPorPeaje> pasadasEnRango = new HashSet<>();
//                for (PasadaPorPeaje pasada : vehiculo.getPasadaPorPeajeList()) {
//                    if (!pasada.getFecha().before(fechaInicio) && !pasada.getFecha().after(fechaFin)) {
//                        pasadasEnRango.add(pasada);
//                    }
//                }
//                return pasadasEnRango;
//            } else {
//                System.out.println("El vehiculo no está vinculado al cliente");
//                return new HashSet<>();
//            }
//        } else {
//            System.out.println("Cliente no encontrado en el repo");
//            return new HashSet<>();
//        }
//    }

}