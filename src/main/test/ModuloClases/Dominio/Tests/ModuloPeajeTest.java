package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
import ModuloPeaje.Dominio.Repo.RepoPeajeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import ModuloPeaje.Dominio.Repo.RepoPeaje;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import ModuloGestionClientes.Dominio.ClienteTelepeaje;

import ModuloPeaje.Aplicacion.ModuloPeajeAplicacion;
import ModuloPeaje.Evento.notificarPasajeVehiculo;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
public class ModuloPeajeTest {

    @Mock
    private ModuloIGestionClientes moduloIGestionClientes;

    @InjectMocks
    private ClienteTelepeaje clienteTelepeajeService;

    @InjectMocks
    private ModuloPeajeImpl moduloPeaje;

    @Mock
    private RepoPeaje repoMock;

    @InjectMocks
    private RepoPeajeImpl repo;

    private Preferencial tarifaPreferencial;
    private Comun tarifaComun;
    private Vehiculo vehiculoNacional;
    private Vehiculo vehiculoExtranjero;
    private Tag tag;
    private String matricula;



    @BeforeEach
    public void setUp() {

     MockitoAnnotations.openMocks(this);
    // Crear un mock del RepoPeaje
    RepoPeaje repoMock = mock(RepoPeaje.class);
    repo = new RepoPeajeImpl(new Preferencial(50.0), new Comun(30.0));

    Tag tag = new Tag("123");
    Matricula matricula = new Matricula("ABC123");
    vehiculoNacional = new Nacional(matricula, tag);
    vehiculoExtranjero = new Extranjero(tag);

    // Utiliza el repositorio mockeado en lugar de la instancia real


        repoMock.altaVehiculo(vehiculoNacional);
        verify(repoMock).altaVehiculo(vehiculoNacional);
        System.out.println("¿Vehículo encontrado? " + vehiculoNacional);
        repoMock.altaVehiculo(vehiculoExtranjero);
}

    @Test
    public void testEstaHabilitadoVehiculoNacional() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Crea una instancia de Preferencial y asigna un valor de tarifa válido
        Preferencial tarifaPreferencial = new Preferencial();
        tarifaPreferencial.setMonto(100.0);

        // Crea una instancia de Vehiculo y configúrala como un vehículo nacional
        Nacional vehiculoNacional = new Nacional();
        vehiculoNacional.setNacionalidad(Nacionalidad.NACIONAL);
        vehiculoNacional.setTag(tag = new Tag("123"));
        Matricula matricula = new Matricula("ABC123");
        vehiculoNacional.setMatricula(matricula);

        System.out.println("dato " + vehiculoNacional.getTag().getIdUnico());
        System.out.println("dato " + vehiculoNacional.getNacionalidad());
        System.out.println("dato " + vehiculoNacional.getMatricula().getNroMatricula());
        moduloPeaje.altaVehiculo(vehiculoNacional);

        // Ejecuta el método a probar
        boolean resultado = moduloPeaje.estaHabilitado(Integer.parseInt(tag.getIdUnico()), matricula.getNroMatricula());

        // Verifica que el resultado sea verdadero
        assertTrue(resultado);
        System.out.println("resultado" + resultado);

    }
//@Test
//public void testEstaHabilitadoVehiculoNacional() {
//
//
//    // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
//    //ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
//    boolean resultado = .estaHabilitado(123, "ABC123");
//
//    assertTrue(resultado);
//    verify(repo, times(1)).BuscarTag(123);
//    verify(repo, never()).BuscarMatricula(anyString());
//}
//
//    @Test
//    public void testEstaHabilitadoVehiculoExtranjero() {
//        // Mock del RepoPeaje
//        RepoPeaje repoMock = mock(RepoPeaje.class);
//        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
//        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
//        when(moduloIGestionClientes.realizarPrePago(123, 50.0)).thenReturn(true);
//
//        boolean resultado = moduloPeaje.estaHabilitado(123, "DEF456");
//
//        assertTrue(resultado);
//        verify(moduloIGestionClientes, times(1)).realizarPrePago(123, 50.0);
//    }
//
//    @Test
//    public void testEstaHabilitadoVehiculoExtranjeroFalloPrePagoExitoPostPago() {
//        // Mock del RepoPeaje
//        RepoPeaje repoMock = mock(RepoPeaje.class);
//        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
//        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
//
//        when(moduloIGestionClientes.realizarPrePago(123, 50.0)).thenReturn(false);
//        when(moduloIGestionClientes.realizarPostPago(123, 50.0)).thenReturn(true);
//
//        boolean resultado = moduloPeaje.estaHabilitado(123, "DEF456");
//
//        assertTrue(resultado);
//        verify(moduloIGestionClientes, times(1)).realizarPrePago(123, 50.0);
//        verify(moduloIGestionClientes, times(1)).realizarPostPago(123, 50.0);
//    }

    @Test
    public void testVehiculoNoEncontrado() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);
        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
        boolean resultado = moduloPeaje.estaHabilitado(999, "XYZ999");
        // Imprime el resultado por consola
        System.out.println("¿Vehículo encontrado? " + (resultado ? "Sí" : "No"));
        assertFalse(resultado);
    }


    @Test
    void testActualizarTarifaComun() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Llama al método para actualizar la tarifa común con un importe específico (por ejemplo, 15.0)
        moduloPeaje.actualizarTarifaComun(15.0);

        // Validación: Verifica que la tarifa común se haya actualizado correctamente
        // En este caso, esperamos que el importe de la tarifa común sea 15.0
        assertEquals(15.0, moduloPeaje.getTarifaComun().getMonto());
        // Si la aserción es verdadera, se imprime un mensaje en la consola
        System.out.println("La tarifa común se ha actualizado correctamente.");
    }

    @Test
    void testActualizarTarifaPreferencial() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Crea un objeto Preferencial con el valor deseado
        Preferencial preferencial = new Preferencial();
        preferencial.setMonto(20.0);

        // Llama al método para actualizar la tarifa preferencial
        moduloPeaje.actualizarTarifaPreferencial(preferencial);

        // Verifica que la tarifa preferencial se haya actualizado correctamente
        Preferencial tarifaPreferencial = moduloPeaje.getTarifaPreferencial();
        assertEquals(20.0, tarifaPreferencial.getMonto());

        // Si la aserción es verdadera, se imprime un mensaje en la consola
        System.out.println("La tarifa preferencial se ha actualizado correctamente.");
    }


}


