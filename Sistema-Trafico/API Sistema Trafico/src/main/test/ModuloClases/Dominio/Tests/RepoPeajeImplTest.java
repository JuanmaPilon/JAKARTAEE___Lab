package ModuloClases.Dominio.Tests;

import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Dominio.*;
import ModuloPeaje.Aplicacion.*;
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
    private EntityManager entityManager;

    private RepoPeajeImpl repoPeaje;

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
    }

    @Test
    @Transactional
    public void testAltaVehiculoExtranjero() {
        repoPeaje.altaVehiculoExtranjero(vehiculoExtranjero);
        verify(entityManager, times(1)).persist(vehiculoExtranjero);
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
        verify(entityManager, times(1)).persist(vehiculoNacional);
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
}
