package ModuloClases.Dominio.Tests;

import ModuloComunicacion.Aplicacion.*;
import ModuloComunicacion.Dominio.*;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class ModuloComunicacionTest {

    @Inject
    private ModuloComunicacion modulo;
    public ModuloComunicacionTest() {
        this.modulo = new ModuloComunicacion();
    }
    @Test
    public void testAltaCliente(){
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.altaCliente(cliente);
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.notificarSaldoInsuficiente(cliente);
    }

    @Test
    public void testNotificarTarjetaBloqueada() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551","pepito@asd.com");
        modulo.notificarTarjetaBloqueada(cliente);
    }

    @Test
    public void testNotificarInformacion() {
        String texto = "pago 50 pesos";
        ClienteTelepeaje cliente = new ClienteTelepeaje("juan","246262365","juan@asd.com");
        modulo.altaCliente(cliente);//el cliente tiene que estar dado de alta en el modulo
        modulo.notificarInformacion(cliente.getCi(), texto);
    }
    @Test
    public void testObtenerNotificacionesPorCliente() {
        ClienteTelepeaje cliente = new ClienteTelepeaje("josue","2345234256","josue@asd.com");
        cliente.agregarNotificacion("Notificación 1");
        cliente.agregarNotificacion("Notificación 2");
        cliente.agregarNotificacion("Notificación 3");

        modulo.altaCliente(cliente);
        //el cliente tiene que estar dado de alta para que obtener noti por cliente pueda obtener las notificaciones del cliente, sino explota
        List<String> notificaciones = modulo.obtenerNotiPorCliente(cliente);

        // Verificar que las notificaciones obtenidas sean las esperadas
        assertEquals(3, notificaciones.size()); // Verificar que se devuelvan 3 notificaciones
        assertTrue(notificaciones.contains("Notificación 1"));
        assertTrue(notificaciones.contains("Notificación 2"));
        assertTrue(notificaciones.contains("Notificación 3"));

    }

}
