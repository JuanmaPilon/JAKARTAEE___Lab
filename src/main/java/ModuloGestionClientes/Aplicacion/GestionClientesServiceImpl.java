package ModuloGestionClientes.Aplicacion;

import jakarta.enterprise.context.ApplicationScoped;

import ModuloGestionClientes.Dominio.*;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GestionClientesServiceImpl implements GestionClientesService {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void altaClienteTeleapeje(Usuario usuario) {
        usuarios.add(usuario);
        // Lógica para el alta del cliente Teleapje
        System.out.println("Alta cliente para Teleapje realizado para usuario: " + usuario.getCi());
    }

    // Método para crear un usuario extranjero
    @Override
    public Usuario crearUsuarioExtranjero(String ci, String nombre, String email) {
        return new UsrExtranjero(ci, nombre, email);
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
}