package ModuloClases.Dominio.Tests;

import ModuloMonitoreo.Aplicacion.ModuloMonitoreo;
import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import ModuloPeaje.Evento.notificarPasajeVehiculo;
import ModuloMonitoreo.Aplicacion.ModuloMonitoreo;
import jakarta.enterprise.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModuloPeajeImplTest {

    @InjectMocks
    private ModuloPeajeImpl moduloPeaje;

    @Mock
    private PublicadorEventoPeaje publicadorEventoPeaje;

    @Mock
    private Event<notificarPasajeVehiculo> pasajeVehiculoEvent;

    @Mock
    private ModuloMonitoreo moduloMonitoreo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configurar el comportamiento del mock para el método publicarPasajeVehiculo
        doAnswer(invocation -> {
            String mensaje = invocation.getArgument(0);
            pasajeVehiculoEvent.fire(new notificarPasajeVehiculo(mensaje));
            return null;
        }).when(publicadorEventoPeaje).publicarPasajeVehiculo(anyString());

        // Configurar el comportamiento del mock para el evento pasajeVehiculoEvent.fire
        doAnswer(invocation -> {
            notificarPasajeVehiculo event = invocation.getArgument(0);
            moduloMonitoreo.notificarPeajeVehiculo(event);
            return null;
        }).when(pasajeVehiculoEvent).fire(any(notificarPasajeVehiculo.class));
    }

    @Test
    public void testManejarNotificarPasajeVehiculo() {
        // Arrange
        String mensajeEsperado = "Pasaje de vehículo detectado";

        // Act
        moduloPeaje.manejarNotificarPasajeVehiculo();

        // Assert
        ArgumentCaptor<notificarPasajeVehiculo> mensajeCaptor = ArgumentCaptor.forClass(notificarPasajeVehiculo.class);
        verify(pasajeVehiculoEvent).fire(mensajeCaptor.capture());
        assertEquals(mensajeEsperado, mensajeCaptor.getValue().getDescripcion());

        // Verify
        verify(pasajeVehiculoEvent).fire(any(notificarPasajeVehiculo.class));
    }
}