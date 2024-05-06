package org.tallerjava.moduloA.dominio.repo;

import ModuloGestionClientes.Aplicacion.GestionClientesService;
import ModuloGestionClientes.Aplicacion.GestionClientesServiceImpl;
import org.junit.jupiter.api.Test;
import ModuloGestionClientes.Dominio.Usuario;
import ModuloGestionClientes.Dominio.UsrExtranjero;
import ModuloGestionClientes.Dominio.UsrNacional;

import static org.junit.jupiter.api.Assertions.*;

public class GestionClientesServiceImplTest {

    @Test
    void testCrearUsuarioExtranjero() {
        GestionClientesService gestionClientesService = new GestionClientesServiceImpl();
        Usuario usuario = gestionClientesService.crearUsuarioExtranjero("123456", "Juan", "juan@example.com");
        assertTrue(usuario instanceof UsrExtranjero);
        assertEquals("123456", usuario.getCi());
        assertEquals("Juan", usuario.getNombreUsuario());
        assertEquals("juan@example.com", usuario.getEmail());
    }

    @Test
    void testCrearUsuarioNacional() {
        GestionClientesService gestionClientesService = new GestionClientesServiceImpl();
        Usuario usuario = gestionClientesService.crearUsuarioNacional("654321", "María", "maria@example.com");
        assertTrue(usuario instanceof UsrNacional);
        assertEquals("654321", usuario.getCi());
        assertEquals("María", usuario.getNombreUsuario());
        assertEquals("maria@example.com", usuario.getEmail());
    }

    // Aquí podrías agregar más pruebas según la funcionalidad que desees verificar
}