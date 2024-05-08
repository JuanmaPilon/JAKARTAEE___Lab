package ModuloGestionClientes.Aplicacion;

import jakarta.enterprise.context.ApplicationScoped;

import ModuloGestionClientes.Dominio.Usuario;
import ModuloGestionClientes.Dominio.UsrExtranjero;
import ModuloGestionClientes.Dominio.UsrNacional;

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
    public Usuario crearUsuarioExtranjero(String ci, String nombre, String email) {
        return new UsrExtranjero(ci, nombre, email);
    }

    // Método para crear un usuario nacional
    public Usuario crearUsuarioNacional(String ci, String nombre, String email) {
        return new UsrNacional(ci, nombre, email);
    }

    public void cargarSaldo(ClienteTelepeaje cliente, Double importe) {
        //conveniendo que tengamos cargarSAldo
        cliente.cargarSaldo(importe);
    }

    public void cargarSaldo(ClienteSucive cliente, Double importe) {
        //conveniendo que tengamos cargarSAldo
        cliente.cargarSaldo(importe);
    }

}