package org.tallerjava.moduloA.dominio.repo;

import ModuloComunicacion.Aplicacion.*;
import ModuloComunicacion.Dominio.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuloComunicacionTest {
    @Test
    public void testNotificarSaldoInsuficiente() {
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        Date fechaVto = new Date();
        PREPaga cuenta = new PREPaga(123123,fechaVto,555);
        cliente.setCuentaPREPaga(cuenta);
        modulo.notificarSaldoInsuficiente(cliente);
    }

    @Test
    public void testNotificarTarjetaBloqueada() {
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        Date fechaVto = new Date();
        POSTPaga cuenta = new POSTPaga(125125,fechaVto);
        cliente.setCuentaPOSTPaga(cuenta);
        modulo.notificarTarjetaBloqueada(cliente);
    }

    @Test
    public void testNotificarInformacion() {
        ModuloComunicacionImpl moduloComunicacion = new ModuloComunicacionImpl();
        String texto = "Información importante";
        moduloComunicacion.notificarInformacion(texto);
    }

    @Test
    public void testAltaCliente(){
        ModuloComunicacionAplicacion modulo = new ModuloComunicacionImpl();
        ClienteTelepeaje cliente = new ClienteTelepeaje();
        modulo.altaCliente(cliente);
    }


}
