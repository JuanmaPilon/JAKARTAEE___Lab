package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Dominio.Repo.RepoPeaje;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import jakarta.enterprise.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ModuloPeajeTest {

    @Mock
    private RepoPeaje repo;

    @Mock
    private PublicadorEventoPeaje pasajeVehiculo;

    @Mock
    private Event<String> vehiculoNoEncontrado;

    @Mock
    private ModuloIGestionClientes moduloIGestionClientes;

    @InjectMocks
    private ModuloPeajeImpl moduloPeaje;

    @BeforeEach
    void setUp() {
        double montoPredeterminado = 10.0;
        double montoPredeterminadoPreferencial = 5.0;
        moduloPeaje.actualizarTarifaComun(montoPredeterminado);
        moduloPeaje.actualizarTarifaPreferencial(new Preferencial(montoPredeterminadoPreferencial));
    }

    @Test
    void testEstaHabilitadoVehiculoNacional() {
        int tag = 123;
        String matricula = "ABC123";
        Nacional vehiculo = new Nacional();
        vehiculo.setTag(new Tag("123"));
        vehiculo.setNacionalidad(Nacionalidad.NACIONAL);

        when(repo.BuscarTag(tag)).thenReturn(vehiculo);

        boolean habilitado = moduloPeaje.estaHabilitado(tag, matricula);

        assertTrue(habilitado);
        verify(repo, times(1)).BuscarTag(tag);
    }

    @Test
    void testEstaHabilitadoVehiculoExtranjero() {
        int tag = 123;
        String matricula = "ABC123";
        Extranjero vehiculo = new Extranjero();
        vehiculo.setTag(new Tag("123"));
        vehiculo.setNacionalidad(Nacionalidad.EXTRANJERO);

        when(repo.BuscarTag(tag)).thenReturn(vehiculo);
        when(repo.obtenerTarifaPreferencial()).thenReturn(new Preferencial(5.0));
        when(moduloIGestionClientes.realizarPrePago(tag, 5.0)).thenReturn(true);

        boolean habilitado = moduloPeaje.estaHabilitado(tag, matricula);

        assertTrue(habilitado);
        verify(repo, times(1)).BuscarTag(tag);
        verify(repo, times(1)).obtenerTarifaPreferencial();
        verify(moduloIGestionClientes, times(1)).realizarPrePago(tag, 5.0);
    }

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
    void testAltaVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        moduloPeaje.altaVehiculo(vehiculo);
        verify(repo, times(1)).altaVehiculo(vehiculo);
    }
    @Test
    void testActualizarTarifaComun() {
        double nuevoMonto = 15.0;
        moduloPeaje.actualizarTarifaComun(nuevoMonto);
        assertEquals(nuevoMonto, moduloPeaje.getTarifaComun().obtenerMonto());
        System.out.println("La tarifa común se ha actualizado correctamente.");
    }

    @Test
    void testActualizarTarifaPreferencial() {
        double nuevoMonto = 7.5;
        Preferencial nuevaTarifa = new Preferencial(nuevoMonto);
        moduloPeaje.actualizarTarifaPreferencial(nuevaTarifa);
        assertEquals(nuevoMonto, moduloPeaje.getTarifaPreferencial().obtenerMonto());
        System.out.println("La tarifa preferencial se ha actualizado correctamente.");
    }
}


