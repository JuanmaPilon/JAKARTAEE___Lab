package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestionClientesServiceImplTest {
    @Inject
    private ModuloGestionClientes gestionClientesService;

    public GestionClientesServiceImplTest() {
        this.gestionClientesService = new ModuloGestionClientes();
    }

    @Test
    void testCrearUsuarioExtranjero() {
        Usuario usuario = gestionClientesService.crearUsuarioExtranjero("123456", "Juan", "juan@example.com");
        System.out.println("Usuario creado: " + usuario.getCi() + ", " + usuario.getNombreUsuario() + ", " + usuario.getEmail());
        assertInstanceOf(UsrExtranjero.class, usuario, "El usuario no es una instancia de UsrExtranjero");
        assertEquals("123456", usuario.getCi(), "El CI no coincide");
        assertEquals("Juan", usuario.getNombreUsuario(), "El nombre no coincide");
        assertEquals("juan@example.com", usuario.getEmail(), "El email no coincide");
    }

    @Test
    void testCrearUsuarioNacional() {
        Usuario usuario = gestionClientesService.crearUsuarioNacional("654321", "María", "maria@example.com");
        System.out.println("Usuario creado: " + usuario.getCi() + ", " + usuario.getNombreUsuario() + ", " + usuario.getEmail());
        assertInstanceOf(UsrNacional.class, usuario, "El usuario no es una instancia de UsrNacional");
        assertEquals("654321", usuario.getCi(), "El CI no coincide");
        assertEquals("María", usuario.getNombreUsuario(), "El nombre no coincide");
        assertEquals("maria@example.com", usuario.getEmail(), "El email no coincide");
    }
    @Test
    void testAltaClienteTeleapeje() {
        Usuario usuario = new Usuario("12345678", "Juan", "juan@example.com");
        gestionClientesService.altaClienteTeleapeje(usuario);
    }
    @Test
    void testCargarSaldoTelepeaje() {
        Usuario usuario = new Usuario("34563456", "Pepe", "pepe@example.com");
        gestionClientesService.altaClienteTeleapeje(usuario);
        ClienteTelepeaje clienteTelepeaje = new ClienteTelepeaje();
        clienteTelepeaje.setCi(usuario.getCi());
        clienteTelepeaje.setNombre(usuario.getNombreUsuario());
        clienteTelepeaje.setEmail(usuario.getEmail());
        gestionClientesService.cargarSaldo(clienteTelepeaje,55.0);
    }
    @Test
    void testCargarSaldoSucive() {
        //Usuario usuario = new Usuario("3456345634", "Roberto", "roberto@example.com");

    }
    // Aquí podrías agregar más pruebas según la funcionalidad que desees verificar
}