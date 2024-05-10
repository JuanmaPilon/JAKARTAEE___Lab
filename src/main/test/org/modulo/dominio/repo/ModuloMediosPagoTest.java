package org.modulo.dominio.repo;
import org.junit.jupiter.api.Test;
import ModuloMediosPago.Aplicacion.*;
import ModuloMediosPago.Dominio.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;


public class ModuloMediosPagoTest {
    @Test
    public void testAltaClienteAsociaTarjeta() {
        ModuloMediosPagoImpl modulo = new ModuloMediosPagoImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        Date fechaApertura = new Date();
        POSTPaga cuentaPOSTPaga = new POSTPaga(123,fechaApertura);
        cliente.setCuentaPOSTPaga(cuentaPOSTPaga);
        Tarjeta tarjeta = new Tarjeta(123456789,"BBVA", fechaApertura);

        // ejecuto altaCliente
        modulo.altaCliente(cliente, tarjeta);

        // verifico que la tarjeta se asocio correctamente a la cuenta POSTPaga del cliente
        assertEquals(tarjeta, cliente.getCuentaPOSTPaga().getTarjeta());
    }
    @Test
    public void testNotificarPagoImprimeDetalles() {
        ModuloMediosPagoImpl modulo = new ModuloMediosPagoImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        Nacional vehiculo = new Nacional(new Matricula("ABC123"), new Tag("TAG123"));
        double importe = 50.0;
        Date fechaVto = new Date();
        Tarjeta tarjeta = new Tarjeta(987654321, "Santander",fechaVto);

        // ejecuto notificarPago
        modulo.notificarPago(cliente, vehiculo, importe, tarjeta);

    }
}
