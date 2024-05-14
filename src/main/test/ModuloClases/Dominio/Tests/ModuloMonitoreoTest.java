package ModuloClases.Dominio.Tests;

import org.junit.jupiter.api.Test;

import ModuloMonitoreo.Aplicacion.*;

public class ModuloMonitoreoTest {

    @Test
    public void testNotificarPasajeVehiculo() {
//        ModuloIMonitoreo modulo = new ModuloMonitoreo();
//        modulo.notificarPasajeVehiculo();
//        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroSucive() {
        ModuloIMonitoreo modulo = new ModuloMonitoreo();
        // modulo.notificarCobroSucive();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroTarjeta() {
//        ModuloIMonitoreo modulo = new ModuloMonitoreo();
//        modulo.notificarCobroTarjeta();
//        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroTarjetaRechazado() {
        ModuloIMonitoreo modulo = new ModuloMonitoreo();
        modulo.notificarCobroTarjetaRechazado();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloIMonitoreo modulo = new ModuloMonitoreo();
        modulo.notificarSaldoInsuficiente();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }
}
