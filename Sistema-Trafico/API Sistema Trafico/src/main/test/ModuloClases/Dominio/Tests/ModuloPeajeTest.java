package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Dominio.Repo.RepoPeaje;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import ModuloPeaje.messaging.EnviarMensajeQueue;
import jakarta.enterprise.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ModuloPeaje.Dominio.Nacionalidad;
import ModuloPeaje.Dominio.Preferencial;
import ModuloPeaje.Dominio.Vehiculo;

import ModuloGestionClientes.Dominio.Repo.RepoClientesImp;
import ModuloPeaje.Evento.eventoVehiculoExtranjero;
import ModuloPeaje.Evento.eventoVehiculoNacional;

import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class ModuloPeajeTest {
    @Mock
    private RepoClientesImp repoGestion;

    @Mock
    private RepoPeaje repo;


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
    public void testVehiculoNoEncontrado() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);
        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
        boolean resultado = moduloPeaje.estaHabilitado("999", "XYZ999");
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

    @Test
    public void testProcesarVehiculoExtranjero_SuccessfulPrePago() {
        // Arrange
        String tag = "TAG123";
        String matricula = "ABC123";
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNacionalidad(Nacionalidad.EXTRANJERO);
        vehiculo.setId(1L);

        when(repo.BuscarTag(tag)).thenReturn(vehiculo);
        when(moduloIGestionClientes.realizarPrePago(tag, 50.0)).thenReturn(true);

        // Act
        boolean resultado = moduloPeaje.estaHabilitado(tag, matricula);

        // Assert
        assertTrue(resultado);
      }

    @Test
    public void testProcesarVehiculoExtranjero_SuccessfulPostPago() {
        // Arrange
        String tag = "TAG123";
        String matricula = "ABC123";
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNacionalidad(Nacionalidad.EXTRANJERO);
        vehiculo.setId(1L);

        when(repo.BuscarTag(tag)).thenReturn(vehiculo);
        when(moduloIGestionClientes.realizarPrePago(tag, 50.0)).thenReturn(false);
        when(moduloIGestionClientes.realizarPostPago(tag, 50.0)).thenReturn(true);

        // Act
        boolean resultado = moduloPeaje.estaHabilitado(tag, matricula);

        // Assert
        assertTrue(resultado);
        }

    @Test
    public void testProcesarVehiculoExtranjero_FailedPayment() {
        // Arrange
        String tag = "TAG123";
        String matricula = "ABC123";
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNacionalidad(Nacionalidad.EXTRANJERO);
        vehiculo.setId(1L);

        when(repo.BuscarTag(tag)).thenReturn(vehiculo);
        when(moduloIGestionClientes.realizarPrePago(tag, 50.0)).thenReturn(false);
        when(moduloIGestionClientes.realizarPostPago(tag, 50.0)).thenReturn(false);

        // Act
        boolean resultado = moduloPeaje.estaHabilitado(tag, matricula);

        // Assert
        assertFalse(resultado);
    }
}


