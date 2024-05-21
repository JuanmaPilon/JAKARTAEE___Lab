package ModuloClases.Dominio.Tests;

import ModuloPeaje.Evento.notificarPasajeVehiculo;
import ModuloSucive.Evento.notificarPagoSucive;
import ModuloMonitoreo.Aplicacion.ModuloMonitoreo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ModuloMonitoreoTest {

    @InjectMocks
    private ModuloMonitoreo moduloMonitoreo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNotificarCobroSucive() {
        // Arrange
        String mensaje = "Pago recibido";
        notificarPagoSucive event = new notificarPagoSucive(mensaje);

        // Act
        moduloMonitoreo.notificarCobroSucive(event);
    }

    @Test
    public void testnotificarPeajeVehiculo() {
        // Arrange
        String mensaje = "Pasaje de vehículo detectado";
        notificarPasajeVehiculo event = new notificarPasajeVehiculo(mensaje);

        // Act
        moduloMonitoreo.notificarPeajeVehiculo(event);
    }
}