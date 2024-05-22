package ModuloClases.Dominio.Tests;

import ModuloPeaje.Evento.notificarPasajeVehiculo;
import ModuloSucive.Evento.notificarPagoSucive;
import ModuloGestionClientes.Evento.notCobroTarjeta;
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
    public void testNotificarPeajeVehiculo() {
        // Arrange
        String mensaje = "Pasaje de vehículo detectado";
        notificarPasajeVehiculo event = new notificarPasajeVehiculo(mensaje);

        // Act
        moduloMonitoreo.notificarPeajeVehiculo(event);
    }

    @Test
    public void testNotificarCobroTarjeta() {
        // Arrange
        String mensaje = "Cobro con Tarjeta realizado";
        notCobroTarjeta event = new notCobroTarjeta(mensaje);

        // Act
        moduloMonitoreo.notificarCobroTarjeta(event);
    }

    @Test
    public void testNotificarCobroTarjetaRechazado() {
        // Arrange
        String mensaje = "Tarjeta Rechazada";
        notCobroTarjeta event = new notCobroTarjeta(mensaje);

        // Act
        moduloMonitoreo.notificarCobroTarjetaRechazado(event);
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        // Arrange
        String mensaje = "Saldo Insuficiente";
        notCobroTarjeta event = new notCobroTarjeta(mensaje);

        // Act
        moduloMonitoreo.notificarSaldoInsuficiente(event);
    }

}