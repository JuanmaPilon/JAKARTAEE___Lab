package ModuloClases.Dominio.Tests;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import ModuloMediosPago.Aplicacion.*;
import ModuloMediosPago.Dominio.*;
//import ModuloComunicacion.Aplicacion.*;
//import ModuloComunicacion.Dominio.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;


public class ModuloMediosPagoTest {
    @Inject
   // private ModuloComunicacion moduloComunicacion;
    private ModuloMediosPagoImpl modulo;

    public ModuloMediosPagoTest() {
        //this.moduloComunicacion = new ModuloComunicacion();
        this.modulo = new ModuloMediosPagoImpl();
    }

    @Test
    public void testAltaCliente() {
        ModuloMediosPago.Dominio.ClienteTelepeaje cliente = new ModuloMediosPago.Dominio.ClienteTelepeaje();
        Date fechaApertura = new Date();
        ModuloMediosPago.Dominio.POSTPaga cuentaPOSTPaga = new ModuloMediosPago.Dominio.POSTPaga(123,fechaApertura);
        cliente.setCuentaPOSTPaga(cuentaPOSTPaga);
        ModuloMediosPago.Dominio.Tarjeta tarjeta = new ModuloMediosPago.Dominio.Tarjeta(123456789,"BBVA", fechaApertura);

        // ejecuto altaCliente
        modulo.altaCliente(cliente, tarjeta);
    }
    @Test
    public void testNotificarPago() {

        ModuloMediosPago.Dominio.ClienteTelepeaje cliente = new ModuloMediosPago.Dominio.ClienteTelepeaje();

        Nacional vehiculo = new Nacional(new Matricula("ABC123"), new Tag("TAG123"));
        double importe = 50.0;
        Date fechaVto = new Date();
        ModuloMediosPago.Dominio.Tarjeta tarjeta = new ModuloMediosPago.Dominio.Tarjeta(987654321, "Santander",fechaVto);

//        ModuloComunicacion.Dominio.ClienteTelepeaje cliente2 = new ModuloComunicacion.Dominio.ClienteTelepeaje();
//
//        cliente2.setEmail(cliente.getEmail());
//        cliente2.setNombre(cliente.getNombre());
//        cliente2.setCi(cliente.getCi());
//        moduloComunicacion.altaCliente(cliente2);
//        // ejecuto notificarPago
//        modulo.notificarPago(cliente, vehiculo, importe, tarjeta);

    }
    @Test
    public void testConsultaDePagosEntreFechas() {
        // Definir las fechas de inicio y fin para la consulta
        Date fechaInicial = new Date(); // Fecha actual
        Date fechaFinal = new Date(System.currentTimeMillis() + 86400000); // Fecha actual + 1 día

        // Ejecutar la operación de consulta
        List<Pagos> pagosEntreFechas = modulo.consultaDePagos(fechaInicial, fechaFinal);

        // Verificar que la lista no sea nula y esté ordenada por fecha
        assertNotNull(pagosEntreFechas);
        assertTrue(isSortedByFecha(pagosEntreFechas));
    }

    // Método auxiliar para verificar si una lista de pagos está ordenada por fecha
    private boolean isSortedByFecha(List<Pagos> pagos) {
        for (int i = 0; i < pagos.size() - 1; i++) {
            if (pagos.get(i).getFecha().after(pagos.get(i + 1).getFecha())) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testConsultaDePagosPorCliente() {
        // cliente y sus datos
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        cliente.setEmail("peper@gmail.com");
        cliente.setNombre("peper");
        cliente.setCi("234246526");

        //datos del pago
        Date fechaPago = new Date(); // Fecha actual
        String tipoPago = "POSTpaga";
        double importe = 100.0;
        String matricula = "ABC123";
        Pagos pago = new Pagos(fechaPago, tipoPago, importe, matricula);

        Date fechaApertura = new Date();
        POSTPaga cuentaPOSTPaga = new POSTPaga(123,fechaApertura);
        cliente.setCuentaPOSTPaga(cuentaPOSTPaga);
        Tarjeta tarjeta = new Tarjeta(123456789,"BBVA", fechaApertura);

        cliente.agregarPago(pago); //seteo pago al cliente

        // ejecuto altaCliente
        modulo.altaCliente(cliente, tarjeta);
        // Ejecutar la operación de consulta
        List<Pagos> pagosCliente = modulo.consultaDePagos(cliente);

        // Verificar que la lista de pagos no sea nula
        assertNotNull(pagosCliente);
    }
    @Test
    public void testConsultaDePagosPorVehiculo() {
        // Crear un cliente de prueba
        ClienteTelepeaje cliente = new ClienteTelepeaje(); // Aquí debes inicializar el cliente con datos de prueba
        cliente.setEmail("juansetokaiba@gmail.com");
        cliente.setNombre("kaiba");
        cliente.setCi("25734575");

        Date fechaPago = new Date(); // Fecha actual
        String tipoPago = "POSTpaga";
        double importe = 100.0;
        String matricula = "ABC123"; //pago con la matricula del vehiculo
        Pagos pago = new Pagos(fechaPago, tipoPago, importe, matricula);

        //vehiculo con la matricula del pago:
        Nacional vehiculo = new Nacional(new Matricula("ABC123"), new Tag("TAG123")); // Aquí debes inicializar el vehículo con datos de prueba

        //doy de alta la tarjeta para que el cliente pueda ser dado de alta en el modulo
        Date fechaApertura = new Date();
        POSTPaga cuentaPOSTPaga = new POSTPaga(123,fechaApertura);
        cliente.setCuentaPOSTPaga(cuentaPOSTPaga);
        Tarjeta tarjeta = new Tarjeta(123456789,"BBVA", fechaApertura);

        cliente.agregarPago(pago); //cliente paga por la matricula de su vehiculo

        modulo.altaCliente(cliente, tarjeta);
        // Ejecutar la operación de consulta
        List<Pagos> pagosVehiculo = modulo.consultaDePagos(cliente, vehiculo);

        // Verificar que la lista de pagos no sea nula
        assertNotNull(pagosVehiculo);
    }

}
