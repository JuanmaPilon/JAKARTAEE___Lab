package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
import ModuloPeaje.Dominio.Repo.RepoPeaje;
import ModuloPeaje.Dominio.Repo.RepoPeajeImpl;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RepoPeajeImplTest {
    @Mock
    private ModuloIGestionClientes moduloIGestionClientes;
    @Mock
    private EntityManager entityManager;

    private RepoPeajeImpl repoPeaje;

    private Vehiculo vehiculo;

    private Extranjero vehiculoExtranjero;
    private Nacional vehiculoNacional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        repoPeaje = new RepoPeajeImpl();
        repoPeaje.setEntityManager(entityManager);  // Establece manualmente el EntityManager

        Tag tag = new Tag("12345");
        vehiculoExtranjero = new Extranjero(tag);

        Matricula matricula = new Matricula("ABC123");
        vehiculoNacional = new Nacional(matricula, tag);

        vehiculoNacional.setNacionalidad(Nacionalidad.NACIONAL);
        vehiculoExtranjero.setNacionalidad(Nacionalidad.EXTRANJERO);
        repoPeaje.altaVehiculo(vehiculo);
        repoPeaje.altaVehiculoNacional(vehiculoNacional);
        repoPeaje.altaVehiculoExtranjero(vehiculoExtranjero);
    }

    @Test
    @Transactional
    public void testAltaVehiculo() {
        repoPeaje.altaVehiculo(vehiculo);
        verify(entityManager, times(2)).persist(vehiculo);
    }

    @Test
    @Transactional
    public void testAltaVehiculoExtranjero() {
        repoPeaje.altaVehiculoExtranjero(vehiculoExtranjero);
        verify(entityManager, times(2)).persist(vehiculoExtranjero);
    }

    @Test
    @Transactional
    public void testBajaVehiculoExtranjero() {
        long id = 1L;
        when(entityManager.find(Extranjero.class, id)).thenReturn(vehiculoExtranjero);
        repoPeaje.bajaVehiculoExtranjero(id);
        verify(entityManager, times(1)).remove(vehiculoExtranjero);
    }

    @Test
    @Transactional
    public void testModificarVehiculoExtranjero() {
        long id = 1L;
        Tag newTag = new Tag("67890");
        Extranjero updatedVehiculoExtranjero = new Extranjero(newTag);
        updatedVehiculoExtranjero.setId(id);

        when(entityManager.find(Extranjero.class, id)).thenReturn(vehiculoExtranjero);
        repoPeaje.modificarVehiculoExtranjero(updatedVehiculoExtranjero);
        verify(entityManager, times(1)).merge(vehiculoExtranjero);
        assertEquals(newTag, vehiculoExtranjero.getTag());
    }

    @Test
    @Transactional
    public void testAltaVehiculoNacional() {
        repoPeaje.altaVehiculoNacional(vehiculoNacional);
        verify(entityManager, times(2)).persist(vehiculoNacional);
    }

    @Test
    @Transactional
    public void testBajaVehiculoNacional() {
        long id = 1L;
        when(entityManager.find(Nacional.class, id)).thenReturn(vehiculoNacional);
        repoPeaje.bajaVehiculoNacional(id);
        verify(entityManager, times(1)).remove(vehiculoNacional);
    }

    @Test
    @Transactional
    public void testModificarVehiculoNacional() {
        long id = 1L;
        Matricula newMatricula = new Matricula("XYZ789");
        Tag newTag = new Tag("67890");
        Nacional updatedVehiculoNacional = new Nacional(newMatricula, newTag);
        updatedVehiculoNacional.setId(id);

        when(entityManager.find(Nacional.class, id)).thenReturn(vehiculoNacional);
        repoPeaje.modificarVehiculoNacional(updatedVehiculoNacional);
        verify(entityManager, times(1)).merge(vehiculoNacional);
        assertEquals(newMatricula, vehiculoNacional.getMatricula());
        assertEquals(newTag, vehiculoNacional.getTag());
    }

    @Test
    public void testAltaTag() {
        Tag tag = new Tag("12345");

        repoPeaje.altaTag(tag);

        verify(entityManager).persist(tag);
    }

    @Test
    public void testBajaTag() {
        Tag tag = new Tag("12345");
        tag.setId(1L);

        when(entityManager.find(Tag.class, 1L)).thenReturn(tag);

        repoPeaje.bajaTag(1L);

        verify(entityManager).remove(tag);
    }

    @Test
    public void testModificarTag() {
        Tag existingTag = new Tag("12345");
        existingTag.setId(1L);

        Tag updatedTag = new Tag("67890");
        updatedTag.setId(1L);

        when(entityManager.find(Tag.class, 1L)).thenReturn(existingTag);

        repoPeaje.modificarTag(updatedTag);

        verify(entityManager).merge(existingTag);
    }


    @Test
    void testActualizarTarifaPreferencial() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);

        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);

        // Crea un objeto Preferencial con el valor deseado
        Preferencial preferencial = new Preferencial();
        preferencial.setMonto(20.0);

        // Llama al método para actualizar la tarifa preferencial
        moduloPeaje.actualizarTarifaPreferencial(preferencial);

        // Verifica que la tarifa preferencial se haya actualizado correctamente
        Preferencial tarifaPreferencial = moduloPeaje.getTarifaPreferencial();
        assertEquals(20.0, tarifaPreferencial.getMonto());

        // Si la aserción es verdadera, se imprime un mensaje en la consola
        System.out.println("La tarifa preferencial se ha actualizado correctamente.");
    }
    @Test
    void testActualizarTarifaComun() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);

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
    public void testVehiculoNoEncontrado() {
        // Mock del RepoPeaje
        RepoPeaje repoMock = mock(RepoPeaje.class);
        // Crea una instancia de ModuloPeajeImpl utilizando el mock de RepoPeaje
        ModuloPeajeImpl moduloPeaje = new ModuloPeajeImpl(repoMock);
        boolean resultado = moduloPeaje.estaHabilitado(999, "XYZ999");
        // Imprime el resultado por consola
        System.out.println("¿Vehículo encontrado? " + (resultado ? "Sí" : "No"));
        assertFalse(resultado);
    }
}
