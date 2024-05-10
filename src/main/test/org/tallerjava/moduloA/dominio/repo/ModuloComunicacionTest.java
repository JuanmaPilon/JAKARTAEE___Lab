package org.tallerjava.moduloA.dominio.repo;

import ModuloComunicacion.Aplicacion.*;
import ModuloComunicacion.Dominio.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuloComunicacionTest {
    @Test
    public void testAltaCliente(){
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.altaCliente(cliente,"pepito@asd.com");
    }

    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.notificarSaldoInsuficiente(cliente);
    }

    @Test
    public void testNotificarTarjetaBloqueada() {
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje("pepe","231234551");
        modulo.notificarTarjetaBloqueada(cliente);
    }

    @Test
    public void testNotificarInformacion() {
        ModuloComunicacionImpl moduloComunicacion = new ModuloComunicacionImpl();
        String texto = "Información importante";
        moduloComunicacion.notificarInformacion(texto);
    }


}
