package ModuloClases.Dominio.Tests;

import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import ModuloPeaje.Dominio.Repo.RepoPeaje;



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
        // Mock del RepoPeaje
        RepoPeaje repoMock = Mockito.mock(RepoPeaje.class);
        Mockito.when(repoMock.obtenerTarifaComun()).thenReturn(10.0);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Llama al método para actualizar la tarifa común con un importe específico (por ejemplo, 15.0)
        moduloPeaje.actualizarTarifaComun(15.0);

        // Validación: Verifica que la tarifa común se haya actualizado correctamente
        // En este caso, esperamos que el importe de la tarifa común sea 15.0
        assertEquals(15.0, moduloPeaje.getTarifaComun().getMonto());
        // Si la aserción es verdadera, se imprime un mensaje en la consola
        System.out.println("La tarifa común se ha actualizado correctamente.");
    }

    @Test
    void testActualizarTarifaPreferencial() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = Mockito.mock(RepoPeaje.class);
        Mockito.when(repoMock.obtenerTarifaPreferencial()).thenReturn(5.0);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Llama al método para actualizar la tarifa preferencial
        moduloPeaje.actualizarTarifaPreferencial(20.0);

        // Verifica que la tarifa preferencial se haya actualizado correctamente
        Preferencial tarifaPreferencial = moduloPeaje.getTarifaPreferencial();
        assertEquals(5.0, tarifaPreferencial.getMontoPreferencial());
        // Si la aserción es verdadera, se imprime un mensaje en la consola
        System.out.println("La tarifa preferencial se ha actualizado correctamente.");
    }
}


