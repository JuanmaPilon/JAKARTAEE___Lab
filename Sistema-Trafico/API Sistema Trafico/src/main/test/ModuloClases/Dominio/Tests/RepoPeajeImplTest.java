package ModuloClases.Dominio.Tests;

import ModuloPeaje.Dominio.*;
import ModuloPeaje.Dominio.Repo.RepoPeajeImpl;
import java.util.Date;
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

    private Vehiculo vehiculo;
    private Matricula matricula;

    private Extranjero vehiculoExtranjero;
    private Nacional vehiculoNacional;

    private PasadaPorPeaje pasadaPorPeaje;

    private Tarifa tarifa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        repoPeaje = new RepoPeajeImpl();
        repoPeaje.setEntityManager(entityManager);  // Establece manualmente el EntityManager

        matricula = new Matricula("ABC123");
        Tag tag = new Tag("12345");
        vehiculoExtranjero = new Extranjero(tag);

        vehiculo = new Vehiculo();
        vehiculo.setId(1L);

        Matricula matricula = new Matricula("ABC123");
        vehiculoNacional = new Nacional(matricula, tag);

        vehiculoNacional.setNacionalidad(Nacionalidad.NACIONAL);
        vehiculoExtranjero.setNacionalidad(Nacionalidad.EXTRANJERO);
        repoPeaje.altaVehiculo(vehiculo);
        repoPeaje.altaVehiculoNacional(vehiculoNacional);
        repoPeaje.altaVehiculoExtranjero(vehiculoExtranjero);
        pasadaPorPeaje = new PasadaPorPeaje(new Date(), 10.0, null);
        pasadaPorPeaje.setId(1L);
        tarifa = new Tarifa(100.0);
        tarifa.setTipoTarifa(TipoTarifa.COMUN);
    }

    @Test
    @Transactional
    public void testAltaVehiculo() {
        repoPeaje.altaVehiculo(vehiculo);
        verify(entityManager, times(2)).persist(vehiculo);
    }

    @Test
    @Transactional
    public void testBajaVehiculo() {
        long id = 1L;
        when(entityManager.find(Vehiculo.class, vehiculo.getId())).thenReturn(vehiculo);

        repoPeaje.bajaVehiculo(vehiculo.getId());

        verify(entityManager, times(1)).remove(vehiculo);
    }

    @Test
    @Transactional
    public void testModificarVehiculo() {
        long id = 1L;
        Tag newTag = new Tag("12345");
        Vehiculo vehiculoModificado = new Vehiculo();
        vehiculoModificado.setId(id);
        vehiculoModificado.setTag(newTag);

        when(entityManager.find(Vehiculo.class, vehiculo.getId())).thenReturn(vehiculo);

        repoPeaje.modificarVehiculo(vehiculoModificado);

        verify(entityManager, times(1)).merge(vehiculo);
        assertEquals("12345", vehiculo.getTag().getIdUnico());
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
    @Transactional
    public void testAltaMatricula() {
        repoPeaje.altaMatricula(matricula);
        verify(entityManager, times(1)).persist(matricula);
    }

    @Test
    @Transactional
    public void testBajaMatricula() {
        String id = "1"; // Aquí proporciona el id correcto de la matrícula que deseas eliminar
        when(entityManager.find(Matricula.class, id)).thenReturn(matricula);

        repoPeaje.bajaMatricula(id);

        verify(entityManager, times(1)).remove(matricula);
    }

    @Test
    @Transactional
    public void testModificarMatricula() {
        long id = 1; // Proporciona el id correcto de la matrícula que deseas modificar
        Matricula matriculaModificada = new Matricula("XYZ789");
        matriculaModificada.setId(id);

        when(entityManager.find(Matricula.class, id)).thenReturn(matricula);

        repoPeaje.modificarMatricula(matriculaModificada);

        verify(entityManager, times(1)).merge(matricula);
        assertEquals("XYZ789", matricula.getNroMatricula());
    }

    @Test
    @Transactional
    public void testAltaPasadaPorPeaje() {
        repoPeaje.altaPasadaPorPeaje(pasadaPorPeaje);

        verify(entityManager, times(1)).persist(pasadaPorPeaje);
    }

    @Test
    @Transactional
    public void testBajaPasadaPorPeaje() {
        when(entityManager.find(PasadaPorPeaje.class, pasadaPorPeaje.getId())).thenReturn(pasadaPorPeaje);

        repoPeaje.bajaPasadaPorPeaje(pasadaPorPeaje.getId());

        verify(entityManager, times(1)).remove(pasadaPorPeaje);
    }

    @Test
    @Transactional
    public void testModificarPasadaPorPeaje() {
        PasadaPorPeaje pasadaPorPeajeModificada = new PasadaPorPeaje(new Date(), 20.0, null);
        pasadaPorPeajeModificada.setId(pasadaPorPeaje.getId());

        when(entityManager.find(PasadaPorPeaje.class, pasadaPorPeaje.getId())).thenReturn(pasadaPorPeaje);

        repoPeaje.modificarPasadaPorPeaje(pasadaPorPeajeModificada);

        verify(entityManager, times(1)).merge(pasadaPorPeaje);
        assertEquals(20.0, pasadaPorPeaje.getCosto());
    }

    @Test
    @Transactional
    public void testAltaTarifa() {
        repoPeaje.altaTarifa(tarifa);
        verify(entityManager, times(1)).persist(tarifa);
    }

    @Test
    @Transactional
    public void testBajaTarifa() {
        int id = 1;
        when(entityManager.find(Tarifa.class, id)).thenReturn(tarifa);
        repoPeaje.bajaTarifa(id);
        verify(entityManager, times(1)).remove(tarifa);
    }

    @Test
    @Transactional
    public void testModificarTarifa() {
        int id = 1;
        tarifa.setId(id);
        Tarifa tarifaModificada = new Tarifa(150.0);
        tarifaModificada.setTipoTarifa(TipoTarifa.PREFERENCIAL);
        tarifaModificada.setId(id);

        when(entityManager.find(Tarifa.class, id)).thenReturn(tarifa);

        repoPeaje.modificarTarifa(tarifaModificada);

        verify(entityManager, times(1)).merge(tarifa);
        assertEquals(150.0, tarifa.getMonto());
        assertEquals(TipoTarifa.PREFERENCIAL, tarifa.getTipoTarifa());
    }

}
