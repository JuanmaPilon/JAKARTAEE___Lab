package ModuloClases.Dominio.Tests;

import ModuloComunicacion.Aplicacion.*;
import ModuloComunicacion.Dominio.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuloComunicacionTest {
    @Test
    public void testAltaCliente(){
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.altaCliente(cliente,"pepito@asd.com");
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.notificarSaldoInsuficiente(cliente);
    }

    @Test
    public void testNotificarTarjetaBloqueada() {
        ModuloIComunicacion modulo = new ModuloComunicacion();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.notificarTarjetaBloqueada(cliente);
    }

    @Test
    public void testNotificarInformacion() {
        ModuloComunicacion moduloComunicacion = new ModuloComunicacion();
        String texto = "Información importante";
        moduloComunicacion.notificarInformacion(texto);
    }


}
