package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloGestionClientes;
import ModuloGestionClientes.Dominio.*;
import ModuloGestionClientes.Dominio.Repo.RepoClientesImp;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
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
    private RepoClientesImp repoClientes;
    @Inject
    private ModuloGestionClientes gestionClientesService;

    @Inject
    private ClienteTelepeaje clienteTelepeaje;
    @Inject
    private Vehiculo vehiculo;
    @BeforeEach
    void setUp() {
        // Inicializa la implementación real del repositorio
        repoClientes = new RepoClientesImp();

        // Inicializa el servicio con el repositorio
        gestionClientesService = new ModuloGestionClientes(repoClientes);

        // Configura los datos iniciales
        clienteTelepeaje = new ClienteTelepeaje();
        PREPaga cuenta = new PREPaga();
        cuenta.setSaldo(100.0);
        clienteTelepeaje.setCuentaPrepaga(cuenta);

        // Crea y configura el vehículo
        vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        vehiculo.setClienteTelepeaje(clienteTelepeaje);

        // Registra el vehículo en el repositorio
        //repoClientes.addVehiculo(vehiculo);

    }

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
       ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear un Tag
        Tag tagA = new Tag("TAG123");

        // Crear un vehículo con ese Tag
        List<PasadaPorPeaje> pasadasPorPeaje = new ArrayList<>();
        Vehiculo vehiculo = new Vehiculo(tagA, pasadasPorPeaje);

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

    @Test
    void testRealizarPrePago_SaldoSuficiente() {

        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear una cuenta PREPaga con saldo suficiente
        PREPaga cuentaPrepaga = new PREPaga();
        cuentaPrepaga.setSaldo(100.0);

        vehiculo.setCliente(cliente);
        cliente.setCuentaPrepaga(cuentaPrepaga);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);

        // Realizar el pago
        boolean resultado = gestionClientesService.realizarPrePago(123, 50.0);

        assertTrue(resultado);
        // Busca el vehículo por el tag
        vehiculo = repoClientes.BuscarTag(Integer.parseInt(tag.getIdUnico()));

        // Verificar que el saldo se haya reducido correctamente
        assertEquals(50.0, cuentaPrepaga.getSaldo(), 0.01, "El saldo no se redujo correctamente.");
        assertEquals(50.0, vehiculo.getClienteTelepeaje().getCuentaPrepaga().getSaldo());
        System.out.println("Test realizado. Saldo esperado: " + 50.0);

    }

    @Test
    void testRealizarPrePago_SaldoInsuficiente() {
        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear una cuenta PREPaga con saldo insuficiente
        PREPaga cuentaPrepaga = new PREPaga();
        cuentaPrepaga.setSaldo(20.0);

        vehiculo.setCliente(cliente);
        cliente.setCuentaPrepaga(cuentaPrepaga);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);

        // Realizar el pago
        gestionClientesService.realizarPrePago(123, 50.0);

        // Verificar que el saldo no se haya reducido
        assertEquals(20.0, cuentaPrepaga.getSaldo(), 0.01, "El saldo debería permanecer igual debido a saldo insuficiente.");
        System.out.println("Saldo insuficiente");
        System.out.println("Su cuenta tiene: "+ cuentaPrepaga.getSaldo());
    }

    @Test
    void testRealizarPrePago_SinCuentaPrepaga() {
        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        vehiculo.setCliente(cliente);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);

        // Realizar el pago
        gestionClientesService.realizarPrePago(123, 50.0);

    }

    @Test
    void testRealizarPostPago_ConTarjeta() throws ParseException {
        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear fecha como cadena
        String fechaVtoStr = "2025-12-31";

        // Crear Tarjeta con la fecha como cadena
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVto = sdf.parse(fechaVtoStr);
        Tarjeta tarjeta = new Tarjeta(1234, "Carlos", new java.sql.Date(fechaVto.getTime()));
        POSTPaga cuentaPostpaga = new POSTPaga(5678, new Date(), tarjeta);
        cliente.asignarCuentaPostpaga(cuentaPostpaga);

        vehiculo.setCliente(cliente);
        cliente.setCuentaPostpaga(cuentaPostpaga);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);


        // Realizar el pago
        gestionClientesService.realizarPostPago(123, 50.0);
        System.out.println("Pago logrado");
    }

    @Test
    void testRealizarPostPago_SinTarjeta() {
        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear una cuenta POSTPaga sin tarjeta asociada
        POSTPaga cuentaPostpaga = new POSTPaga(5678, new Date(), null);
        cliente.asignarCuentaPostpaga(cuentaPostpaga);

        vehiculo.setCliente(cliente);
        cliente.setCuentaPostpaga(cuentaPostpaga);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);

        // Realizar el pago
        gestionClientesService.realizarPostPago(123, 50.0);


    }

    @Test
    void testRealizarPostPago_SinCuentaPostpaga() {
        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("123");
        vehiculo.setTag(tag);
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());


        vehiculo.setCliente(cliente);
        repoClientes.agregarClienteTelepeaje(cliente);
        repoClientes.addVehiculo(vehiculo);

        // Realizar el pago
        gestionClientesService.realizarPostPago(123, 50.0);
    }

    @Test
    void testConsultarSaldo_ClienteSucive_Encontrado() {
        // Crear un cliente Sucive existente
        ClienteSucive cliente = new ClienteSucive("Juan", "12345678", new ArrayList<>());
        cliente.cargarSaldo(100.0);

        // Consultar saldo del cliente Sucive existente
        gestionClientesService.consultarSaldo(cliente);

    }

    @Test
    void testConsultarSaldo_ClienteTelepeaje_Encontrado() {
        // Crear un cliente Telepeaje existente
        ClienteTelepeaje cliente = new ClienteTelepeaje("Pedro", "87654321", "pedro@example.com", new ArrayList<>());
        cliente.cargarSaldo(200.0);

        // Consultar saldo del cliente Telepeaje existente
        gestionClientesService.consultarSaldo(cliente);

    }

    @Test
    void testConsultarSaldo_ClienteSucive_NoEncontrado() {
        // Crear un cliente Sucive no existente
        ClienteSucive cliente = new ClienteSucive("Juan", "12345678", new ArrayList<>());

        // Consultar saldo de un cliente Sucive no existente
        gestionClientesService.consultarSaldo(cliente);
    }

    @Test
    void testConsultarSaldo_ClienteTelepeaje_NoEncontrado() {
        // Crear un cliente Telepeaje no existente
        ClienteTelepeaje cliente = new ClienteTelepeaje("Pedro", "87654321", "pedro@example.com", new ArrayList<>());

        // Consultar saldo de un cliente Telepeaje no existente
        gestionClientesService.consultarSaldo(cliente);
    }

    @Test
    void testAsociarTarjeta_ClienteTelepeaje() throws ParseException {
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear fecha como cadena
        String fechaVtoStr = "2025-12-31";

        // Crear Tarjeta con la fecha como cadena
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVto = sdf.parse(fechaVtoStr);
        Tarjeta tarjeta = new Tarjeta(1234, "Carlos", new java.sql.Date(fechaVto.getTime()));

        // Asociar la tarjeta al cliente
        gestionClientesService.asociarTarjeta(cliente, tarjeta);
    }

    @Test
    void testAsociarTarjeta_ClienteSucive() throws ParseException {
        // Crear un cliente de Sucive
        ClienteSucive cliente = new ClienteSucive("Juan", "12345678", new ArrayList<>());

        // Crear fecha como cadena
        String fechaVtoStr = "2025-12-31";

        // Crear Tarjeta con la fecha como cadena
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVto = sdf.parse(fechaVtoStr);
        Tarjeta tarjeta = new Tarjeta(1234, "Juan", new java.sql.Date(fechaVto.getTime()));

        // Asociar la tarjeta al cliente
        gestionClientesService.asociarTarjeta(cliente, tarjeta);
    }

    @Test
    void testConsultarPasadas_ClienteTelepeaje() throws ParseException {
        // Crear un cliente de Telepeaje
        ClienteTelepeaje cliente = new ClienteTelepeaje("Carlos", "98765432", "carlos@example.com", new ArrayList<>());

        // Crear fechas como cadenas
        String fechaInicioStr = "2025-01-01";
        String fechaFinStr = "2025-12-31";

        // Convertir las cadenas a objetos de tipo Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = new java.sql.Date(sdf.parse(fechaInicioStr).getTime());
        Date fechaFin = new java.sql.Date(sdf.parse(fechaFinStr).getTime());

        // Consultar pasadas por peaje
        Set<PasadaPorPeaje> pasadas = gestionClientesService.consultarPasadas(cliente, fechaInicio, fechaFin);
    }

    @Test
    void testConsultarPasadas_ClienteSucive() throws ParseException {
        // Crear un cliente de Sucive
        ClienteSucive cliente = new ClienteSucive("Juan", "12345678", new ArrayList<>());

        // Crear fechas como cadenas
        String fechaInicioStr = "2025-01-01";
        String fechaFinStr = "2025-12-31";

        // Convertir las cadenas a objetos de tipo Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = new java.sql.Date(sdf.parse(fechaInicioStr).getTime());
        Date fechaFin = new java.sql.Date(sdf.parse(fechaFinStr).getTime());

        // Consultar pasadas por peaje
        Set<PasadaPorPeaje> pasadas = gestionClientesService.consultarPasadas(cliente, fechaInicio, fechaFin);
    }

    @Test
    void testVincularVehiculo_ClienteTelepeaje() {
        // Crear un cliente de Telepeaje
        ClienteTelepeaje clienteTelepeaje = new ClienteTelepeaje("Juan", "12345678", "juan@example.com", new ArrayList<>());

        // Agregar el cliente al repositorio
        repoClientes.agregarClienteTelepeaje(clienteTelepeaje);

        ClienteTelepeaje clienteEnRepo = repoClientes.buscarClienteTelePorCI("12345678");
        assertNotNull(clienteEnRepo, "El cliente debería existir en el repositorio.");

        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo();
        Tag tag = new Tag("456");
        vehiculo.setTag(tag);

        // Vincular el vehículo al cliente
        gestionClientesService.vincularVehiculo(clienteTelepeaje, vehiculo);

        // Verificar que el vehículo esté vinculado al cliente en el repositorio

        clienteEnRepo = repoClientes.buscarClienteTelePorCI("12345678");
        assertNotNull(clienteEnRepo);
        assertTrue(clienteEnRepo.getVehiculosCliente().contains(vehiculo), "El vehiculo debería estar vinculado al cliente de Telepeaje.");

        }
}



