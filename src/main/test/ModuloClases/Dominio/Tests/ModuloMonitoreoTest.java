package ModuloClases.Dominio.Tests;

import ModuloMonitoreo.Aplicacion.*;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModuloMonitoreoTest {

    // Creamos una instancia de ModuloMonitoreo
    ModuloMonitoreo moduloMonitoreo = new ModuloMonitoreo();

    // Test para notificarPasajeVehiculo
    @Test
    public void testNotificarPasajeVehiculo() {
        moduloMonitoreo.notificarPasajeVehiculo("Mensaje de prueba");
        // Verificamos la salida esperada
        // Aquí asumimos que el método imprime en la consola,
        // por lo que no podemos capturar su salida directamente en una variable
        // Pero podrías redirigir System.out a un PrintStream en memoria si necesitas hacerlo
    }

    // Test para notificarCobroSucive
    @Test
    public void testNotificarCobroSucive() {
        moduloMonitoreo.notificarCobroSucive("Mensaje de prueba para cobro con Sucive");
        // Aquí también asumimos que el método imprime en la consola
    }

    // Test para notificarCobroTarjeta
    @Test
    public void testNotificarCobroTarjeta() {
        moduloMonitoreo.notificarCobroTarjeta("Evento de prueba para cobro con tarjeta");
        // Igualmente, asumimos que el método imprime en la consola
    }

    // Test para notificarCobroTarjetaRechazado
    @Test
    public void testNotificarCobroTarjetaRechazado() {
        moduloMonitoreo.notificarCobroTarjetaRechazado("Mensaje de prueba para cobro rechazado por tarjeta");
        // Igualmente, asumimos que el método imprime en la consola
    }

    // Test para notificarSaldoInsuficiente
    @Test
    public void testNotificarSaldoInsuficiente() {
        moduloMonitoreo.notificarSaldoInsuficiente("Mensaje de prueba para saldo insuficiente");
        // Igualmente, asumimos que el método imprime en la consola
    }
}
