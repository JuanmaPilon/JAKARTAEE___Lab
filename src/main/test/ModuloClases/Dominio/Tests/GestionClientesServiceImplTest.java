package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.*;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    void testObtenerCuentasPorTag() throws ParseException {
        // Crear un cliente de Telepeaje
        ModuloGestionClientes.Dominio.ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear un Tag
        ModuloGestionClientes.Dominio.Tag tagA = new ModuloGestionClientes.Dominio.Tag("TAG123");

        // Crear un vehículo con ese Tag
        List<ModuloGestionClientes.Dominio.PasadaPorPeaje> pasadasPorPeaje = new ArrayList<>();
        ModuloGestionClientes.Dominio.Vehiculo vehiculo = new ModuloGestionClientes.Dominio.Vehiculo(tagA, pasadasPorPeaje);

        // Agregar el vehículo al cliente
        cliente.agregarVehiculoACliente(vehiculo);

        // Asignar cuentas PREPaga y POSTPaga al cliente
        PREPaga cuentaPrepaga = new PREPaga();
        cuentaPrepaga.setSaldo(100.0);
        cliente.asignarCuentaPrepaga(cuentaPrepaga);

        // Crear fecha como cadena
        String fechaVtoStr = "2025-12-31";

        // Crear Tarjeta con la fecha como cadena
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVto = sdf.parse(fechaVtoStr);
        Tarjeta tarjeta = new Tarjeta(1234, "Carlos", new java.sql.Date(fechaVto.getTime()));  // Creación de java.sql.Date a partir de java.util.Date

        POSTPaga cuentaPostpaga = new POSTPaga(5678, fechaVto, tarjeta);
        cliente.asignarCuentaPostpaga(cuentaPostpaga);

        // Obtener cuentas por Tag
        Set<Object> cuentasPorTag = gestionClientesService.obtenerCuentasPorTag(cliente, tagA);

        // Verificar que las cuentas obtenidas son correctas
        Set<Object> expectedCuentas = new HashSet<>();
        expectedCuentas.add(cuentaPrepaga);
        expectedCuentas.add(cuentaPostpaga);

        assertEquals(expectedCuentas, cuentasPorTag, "Las cuentas obtenidas por Tag no son correctas.");
    }
    
}