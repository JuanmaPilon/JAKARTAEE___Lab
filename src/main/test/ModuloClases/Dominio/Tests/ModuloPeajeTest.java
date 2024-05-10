package ModuloClases.Dominio.Tests;

import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModuloPeajeTest {

    @Test
    void testEstaHabilitado_Tag() {
        // Crea un tag simulado
        Tag tagAutorizado = new Tag("ID_TAG_1");

        // Crea una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Prueba si el tag está habilitado
        boolean resultado = moduloPeaje.estaHabilitado(tagAutorizado);
        System.out.println("¿El tag está habilitado? " + resultado);
        assertTrue(resultado);
    }

    @Test
    void testEstaHabilitado_Matricula() {
        // Crea una matrícula simulada
        Matricula matriculaAutorizada = new Matricula("123ABC");

        // Crea una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Prueba si la matrícula está habilitada
        boolean resultado = moduloPeaje.estaHabilitado(matriculaAutorizada);
        System.out.println("¿La matrícula está habilitada? " + resultado);
        assertTrue(resultado);
    }

    @Test
    void testEstaHabilitado_OtroTipo() {
        // Crea un identificador simulado de otro tipo
        Identificador otroIdentificador = () -> "";

        // Crea una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();

        // Prueba si el identificador de otro tipo no está habilitado
        boolean resultado = moduloPeaje.estaHabilitado(otroIdentificador);
        System.out.println("¿El identificador de otro tipo está habilitado? " + resultado);
        assertFalse(resultado);
    }

    @Test
    void testActualizarTarifaComun() {
        // Crea una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();


        double nuevoImporte = 15.0;

        // Actualiza la tarifa común
        moduloPeaje.actualizarTarifaComun(nuevoImporte);

        // Obtiene el importe actualizado de la tarifa común
        double importeActualizado = moduloPeaje.getTarifaComun().obtenerMonto();

        // Verificacion
        assertEquals(nuevoImporte, importeActualizado, "La tarifa común no se actualizó correctamente");

        if (nuevoImporte == importeActualizado) {
            System.out.println("El test  de la tarifa comun pasó correctamente.");
        } else {
            System.out.println("El test de la tarifa comun falló.");
        }
    }


    @Test
    void testActualizarTarifaPreferencial() {
        // Crea una instancia del módulo de peaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl();


        double nuevoImporte = 10.0;

        // Actualiza la tarifa Preferencial
        moduloPeaje.actualizarTarifaPreferencial(nuevoImporte);

        // Obtiene el importe actualizado de la tarifa Preferencial
        double importeActualizado = moduloPeaje.getTarifaPreferencial().obtenerMontoPreferencial();

        // Verificacion
        assertEquals(nuevoImporte, importeActualizado, "La tarifa Preferencial no se actualizó correctamente");

        if (nuevoImporte == importeActualizado) {
            System.out.println("El test  de la tarifa Preferencial pasó correctamente.");
        } else {
            System.out.println("El test de la tarifa Preferencial falló.");
        }
    }
}

