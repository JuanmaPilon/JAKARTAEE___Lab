package org.tallerjava.moduloA.dominio.repo;

import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModuloPeajeTest {

    @Test
    void testEstaHabilitado_Tag() {
        // Creamos un tag simulado
        Tag tagAutorizado = new Tag("ID_TAG_1");

        // Creamos una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Probamos si el tag está habilitado
        boolean resultado = moduloPeaje.estaHabilitado(tagAutorizado);
        System.out.println("¿El tag está habilitado? " + resultado);
        assertTrue(resultado);
    }

    @Test
    void testEstaHabilitado_Matricula() {
        // Creamos una matrícula simulada
        Matricula matriculaAutorizada = new Matricula("123ABC");

        // Creamos una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Probamos si la matrícula está habilitada
        boolean resultado = moduloPeaje.estaHabilitado(matriculaAutorizada);
        System.out.println("¿La matrícula está habilitada? " + resultado);
        assertTrue(resultado);
    }

    @Test
    void testEstaHabilitado_OtroTipo() {
        // Creamos un identificador simulado de otro tipo
        Identificador otroIdentificador = () -> "";

        // Creamos una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Probamos si el identificador de otro tipo no está habilitado
        boolean resultado = moduloPeaje.estaHabilitado(otroIdentificador);
        System.out.println("¿El identificador de otro tipo está habilitado? " + resultado);
        assertFalse(resultado);
    }
}

