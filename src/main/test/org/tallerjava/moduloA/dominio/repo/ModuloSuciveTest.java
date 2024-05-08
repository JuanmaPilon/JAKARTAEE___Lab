package org.tallerjava.moduloA.dominio.repo;

import ModuloSucive.Aplicacion.*;
import ModuloSucive.Dominio.*;
import org.junit.jupiter.api.Test;

public class ModuloSuciveTest {
    @Test
    public void testNotificarPago() {
        ModuloSuciveAplicacion modulo = new ModuloSuciveImpl();
        Matricula mat = new Matricula("ABCD123");

        //pruebo notiifcar pago
        modulo.notificarPago(mat,500);

    }

}
