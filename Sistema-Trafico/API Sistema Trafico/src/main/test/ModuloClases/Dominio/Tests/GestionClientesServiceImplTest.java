package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloGestionClientes.Dominio.*;
import ModuloGestionClientes.Dominio.Repo.RepoClientes;
import ModuloGestionClientes.Dominio.Repo.RepoClientesImp;
import ModuloGestionClientes.Evento.PublicadorEventoClientes;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GestionClientesServiceImplTest {
    @InjectMocks
    private ModuloGestionClientes moduloGestionClientes;

    @Mock
    private RepoClientesImp repoClientes;

    @Mock
    private PublicadorEventoClientes pagoTarjeta;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        moduloGestionClientes = new ModuloGestionClientes(repoClientes);
    }

    @Test
    public void testAltaClienteTelepeaje_ClienteNoExistente() {
        Usuario usuario = new Usuario("Nombre", "CI123", "email@example.com");
        when(repoClientes.buscarClienteTelePorCI(usuario.getCi())).thenReturn(null);

        moduloGestionClientes.altaClienteTeleapeje(usuario);

        verify(repoClientes, times(1)).agregarClienteTelepeaje(any(ClienteTelepeaje.class));
    }

    @Test
    public void testAltaClienteTelepeaje_ClienteExistente() {
        Usuario usuario = new Usuario("Nombre", "CI123", "email@example.com");
        ClienteTelepeaje clienteExistente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        when(repoClientes.buscarClienteTelePorCI(usuario.getCi())).thenReturn(clienteExistente);

        moduloGestionClientes.altaClienteTeleapeje(usuario);

        verify(repoClientes, times(0)).agregarClienteTelepeaje(any(ClienteTelepeaje.class));
    }

    @Test
    public void testCargarSaldoClienteTelepeaje_ClienteExistente() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.cargarSaldo(cliente, 100.0);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testCargarSaldoClienteTelepeaje_ClienteNoExistente() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(null);

        moduloGestionClientes.cargarSaldo(cliente, 100.0);

        verify(repoClientes, times(0)).actualizarCliente(any(ClienteTelepeaje.class));
    }

    @Test
    public void testVincularVehiculoClienteSucive() {
        ClienteSucive cliente = new ClienteSucive("Nombre", "CI123", new ArrayList<>());
        Tag tag = new Tag("ID_Unico");
        Vehiculo vehiculo = new Vehiculo(tag);
        //Vehiculo vehiculo = new Vehiculo("Vehiculo1", "Placa123");
        when(repoClientes.buscarClienteSucPorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.vincularVehiculo(cliente, vehiculo);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testVincularVehiculoClienteTelepeaje() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        Tag tag = new Tag("ID_Unico");
         Vehiculo vehiculo = new Vehiculo(tag);when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.vincularVehiculo(cliente, vehiculo);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testDesvincularVehiculoClienteTelepeaje() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        Tag tag = new Tag("ID_Unico");
        Vehiculo vehiculo = new Vehiculo(tag);cliente.agregarVehiculoACliente(vehiculo);
        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.desvincularVehiculo(cliente, vehiculo);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testDesvincularVehiculoClienteSucive() {
        ClienteSucive cliente = new ClienteSucive("Nombre", "CI123", new ArrayList<>());
        Tag tag = new Tag("ID_Unico");
        Vehiculo vehiculo = new Vehiculo(tag);
        cliente.agregarVehiculoACliente(vehiculo);
        cliente.agregarVehiculoACliente(vehiculo);
        when(repoClientes.buscarClienteSucPorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.desvincularVehiculo(cliente, vehiculo);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testConsultarSaldoClienteTelepeaje() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);

        Double saldo = moduloGestionClientes.consultarSaldo(cliente);

        assertNotNull(saldo);
        verify(repoClientes, times(1)).buscarClienteTelePorCI(cliente.getCi());
    }

    @Test
    public void testConsultarSaldoClienteSucive() {
        ClienteSucive cliente = new ClienteSucive("Nombre", "CI123", new ArrayList<>());
        when(repoClientes.buscarClienteSucPorCI(cliente.getCi())).thenReturn(cliente);

        Double saldo = moduloGestionClientes.consultarSaldo(cliente);

        assertNotNull(saldo);
        verify(repoClientes, times(1)).buscarClienteSucPorCI(cliente.getCi());
    }

    @Test
    public void testRealizarPrePago() {
        Tag tag = new Tag("1234");
        Vehiculo vehiculo = new Vehiculo(tag);

        vehiculo.setTag(tag);
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        cliente.setCuentaPrepaga(new PREPaga(500.0));
        vehiculo.setClienteTelepeaje(cliente);

        when(repoClientes.BuscarTag(anyString())).thenReturn(vehiculo);

        boolean result = moduloGestionClientes.realizarPrePago("1234", 100.0);

        assertTrue(result);
        verify(repoClientes, times(1)).BuscarTag("1234");
    }

    @Test
    public void testRealizarPostPago() {
        Tag tag = new Tag("1234");
        Vehiculo vehiculo = new Vehiculo(tag);
        vehiculo.setTag(tag);
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        Tarjeta tarjeta = new Tarjeta(123, "123456789");
        cliente.setCuentaPostpaga(new POSTPaga(tarjeta));
        vehiculo.setClienteTelepeaje(cliente);

        when(repoClientes.BuscarTag(anyString())).thenReturn(vehiculo);

        boolean result = moduloGestionClientes.realizarPostPago("1234", 100.0);

        assertTrue(result);
        verify(repoClientes, times(1)).BuscarTag("1234");
    }

    @Test
    public void testAsociarTarjetaClienteTelepeaje() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
        Tarjeta tarjeta = new Tarjeta(123,"123456789");
        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.asociarTarjeta(cliente, tarjeta);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

    @Test
    public void testAsociarTarjetaClienteSucive() {
        ClienteSucive cliente = new ClienteSucive("Nombre", "CI123", new ArrayList<>());
        Tarjeta tarjeta = new Tarjeta(123,"123456789");
        when(repoClientes.buscarClienteSucPorCI(cliente.getCi())).thenReturn(cliente);

        moduloGestionClientes.asociarTarjeta(cliente, tarjeta);

        verify(repoClientes, times(1)).actualizarCliente(cliente);
    }

//    @Test
//    public void testConsultarPasadasClienteTelepeaje() {
//        ClienteTelepeaje cliente = new ClienteTelepeaje("Nombre", "CI123", "email@example.com", new ArrayList<>());
//        Date fechaInicio = new Date();
//        Date fechaFin = new Date();
//
//        when(repoClientes.buscarClienteTelePorCI(cliente.getCi())).thenReturn(cliente);
//
//        Set<PasadaPorPeaje> pasadas = moduloGestionClientes.consultarPasadas(cliente, fechaInicio, fechaFin);
//
//        assertNotNull(pasadas);
//        verify(repoClientes, times(1)).buscarClienteTelePorCI(cliente.getCi());
//    }

    @Test
    public void testConsultarPasadasClienteSucive() {
        ClienteSucive cliente = new ClienteSucive("Nombre", "CI123", new ArrayList<>());
        Date fechaInicio = new Date();
        Date fechaFin = new Date();

        when(repoClientes.buscarClienteSucPorCI(cliente.getCi())).thenReturn(cliente);

        Set<PasadaPorPeaje> pasadas = moduloGestionClientes.consultarPasadas(cliente, fechaInicio, fechaFin);

        assertNotNull(pasadas);
        verify(repoClientes, times(1)).buscarClienteSucPorCI(cliente.getCi());
    }
}



