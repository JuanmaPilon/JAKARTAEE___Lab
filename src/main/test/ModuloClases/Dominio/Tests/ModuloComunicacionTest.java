package ModuloClases.Dominio.Tests;

import ModuloComunicacion.Aplicacion.*;
import ModuloComunicacion.Dominio.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModuloComunicacionTest {
    @Test
    public void testAltaCliente(){
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.altaCliente(cliente);
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.notificarSaldoInsuficiente(cliente);
    }

    @Test
    public void testNotificarTarjetaBloqueada() {
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.notificarTarjetaBloqueada(cliente);
    }

    @Test
    public void testNotificarInformacion() {
        ModuloComunicacion moduloComunicacion = new ModuloComunicacion();
        String texto = "Información importante";
        moduloComunicacion.notificarInformacion(texto);
    }
    @Test
    public void testObtenerNotificacionesPorCliente() {
        ModuloComunicacion moduloComunicacion = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("josue","2345234256","josue@asd.com");
        cliente.agregarNotificacion("Notificación 1");
        cliente.agregarNotificacion("Notificación 2");
        cliente.agregarNotificacion("Notificación 3");

        List<String> notificaciones = moduloComunicacion.obtenerNotiPorCliente(cliente);

        // Verificar que las notificaciones obtenidas sean las esperadas
        assertEquals(3, notificaciones.size()); // Verificar que se devuelvan 3 notificaciones
        assertTrue(notificaciones.contains("Notificación 1"));
        assertTrue(notificaciones.contains("Notificación 2"));
        assertTrue(notificaciones.contains("Notificación 3"));

        //no se si este test este completo, tiene cosas raras
        //tendria que solucionarse obtenerNotiPorCliente antes
    }

}