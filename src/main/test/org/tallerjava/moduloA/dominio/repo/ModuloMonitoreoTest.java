package org.tallerjava.moduloA.dominio.repo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModuloMonitoreoTest {

    @Test
    public void testNotificarPasajeVehiculo() {
        ModuloMonitoreoAplicacion modulo = new ModuloMonitoreoImpl();
        modulo.notificarPasajeVehiculo();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroSucive() {
        ModuloMonitoreoAplicacion modulo = new ModuloMonitoreoImpl();
        modulo.notificarCobroSucive();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroTarjeta() {
        ModuloMonitoreoAplicacion modulo = new ModuloMonitoreoImpl();
        modulo.notificarCobroTarjeta();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarCobroTarjetaRechazado() {
        ModuloMonitoreoAplicacion modulo = new ModuloMonitoreoImpl();
        modulo.notificarCobroTarjetaRechazado();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloMonitoreoAplicacion modulo = new ModuloMonitoreoImpl();
        modulo.notificarSaldoInsuficiente();
        // No hay nada para asertar, ya que el método simplemente imprime en la consola
    }
}
