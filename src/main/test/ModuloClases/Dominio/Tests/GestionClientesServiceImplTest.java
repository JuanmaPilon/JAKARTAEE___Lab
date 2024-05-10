package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import org.junit.jupiter.api.Test;
import ModuloGestionClientes.Dominio.Usuario;
import ModuloGestionClientes.Dominio.UsrRepo;
import ModuloGestionClientes.Dominio.UsrNacional;

import static org.junit.jupiter.api.Assertions.*;

public class GestionClientesServiceImplTest {

    @Test
    void testCrearUsuarioExtranjero() {
        ModuloIGestionClientes gestionClientesService = new ModuloGestionClientes();
        Usuario usuario = gestionClientesService.crearUsuarioExtranjero("123456", "Juan", "juan@example.com");
        System.out.println("Usuario creado: " + usuario.getCi() + ", " + usuario.getNombreUsuario() + ", " + usuario.getEmail());
        assertTrue(usuario instanceof UsrRepo, "El usuario no es una instancia de UsrExtranjero");
        assertEquals("123456", usuario.getCi(), "El CI no coincide");
        assertEquals("Juan", usuario.getNombreUsuario(), "El nombre no coincide");
        assertEquals("juan@example.com", usuario.getEmail(), "El email no coincide");
    }

    @Test
    void testCrearUsuarioNacional() {
        ModuloIGestionClientes gestionClientesService = new ModuloGestionClientes();
        Usuario usuario = gestionClientesService.crearUsuarioNacional("654321", "María", "maria@example.com");
        System.out.println("Usuario creado: " + usuario.getCi() + ", " + usuario.getNombreUsuario() + ", " + usuario.getEmail());
        assertTrue(usuario instanceof UsrNacional, "El usuario no es una instancia de UsrNacional");
        assertEquals("654321", usuario.getCi(), "El CI no coincide");
        assertEquals("María", usuario.getNombreUsuario(), "El nombre no coincide");
        assertEquals("maria@example.com", usuario.getEmail(), "El email no coincide");
    }

    // Aquí podrías agregar más pruebas según la funcionalidad que desees verificar
}