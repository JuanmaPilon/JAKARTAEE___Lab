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
    void testAltaClienteSucive() {
        Usuario usuario = new Usuario("12345678", "Juan", "juan@example.com");
        gestionClientesService.altaClienteSucksive(usuario);
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
        Usuario usuario = new Usuario("3456345634", "Roberto", "roberto@example.com");
        gestionClientesService.altaClienteSucksive(usuario);
        ClienteSucive clienteSucive = new ClienteSucive();
        clienteSucive.setCi(usuario.getCi());
        clienteSucive.setNombre(usuario.getNombreUsuario());
        gestionClientesService.cargarSaldo(clienteSucive,55.0);
    }
    
}