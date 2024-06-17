package ModuloClases.Dominio.Tests;


import ModuloGestionClientes.Dominio.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import ModuloGestionClientes.Dominio.Repo.*;
@ExtendWith(MockitoExtension.class)
public class RepoClientesImpTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private RepoClientesImp repoClientes;

    @BeforeEach
    void setUp() {
        repoClientes = new RepoClientesImp();
        repoClientes.setEntityManager(em);
    }

    @Test
    void testAltaMatricula() {
        Matricula matricula = new Matricula("ABC123");

        repoClientes.altaMatricula(matricula);

        verify(em, times(1)).persist(matricula);
    }

    @Test
    void testBajaMatricula() {
        Matricula matricula = new Matricula(1L, "ABC123");
        when(em.find(Matricula.class, 1L)).thenReturn(matricula);

        repoClientes.bajaMatricula(1L);

        verify(em, times(1)).remove(matricula);
    }


    @Test
    void testModificarMatricula() {
        Matricula matricula = new Matricula(1L, "ABC123");
        Matricula matriculaExistente = new Matricula(1L, "XYZ789");
        when(em.find(Matricula.class, 1L)).thenReturn(matriculaExistente);

        repoClientes.modificarMatricula(matricula);

        assertEquals("ABC123", matriculaExistente.getNroMatricula());
        verify(em, times(1)).merge(matriculaExistente);
    }

    @Test
    void testAltaPasadaPorPeaje() {
        PasadaPorPeaje pasadaPorPeaje = new PasadaPorPeaje();
        pasadaPorPeaje.setId(1L);

        repoClientes.altaPasadaPorPeaje(pasadaPorPeaje);

        verify(em, times(1)).persist(pasadaPorPeaje);
    }

    @Test
    void testBajaPasadaPorPeaje() {
        PasadaPorPeaje pasadaPorPeaje = new PasadaPorPeaje();
        pasadaPorPeaje.setId(1L);
        when(em.find(PasadaPorPeaje.class, 1L)).thenReturn(pasadaPorPeaje);

        repoClientes.bajaPasadaPorPeaje(1L);

        verify(em, times(1)).remove(pasadaPorPeaje);
    }

    @Test
    void testModificarPasadaPorPeaje() {
        PasadaPorPeaje pasadaPorPeaje = new PasadaPorPeaje();
        pasadaPorPeaje.setId(1L);
        PasadaPorPeaje existingPasadaPorPeaje = new PasadaPorPeaje();
        existingPasadaPorPeaje.setId(1L);
        when(em.find(PasadaPorPeaje.class, 1L)).thenReturn(existingPasadaPorPeaje);

        repoClientes.modificarPasadaPorPeaje(pasadaPorPeaje);

        verify(em, times(1)).merge(existingPasadaPorPeaje);
    }

    @Test
    void testAltaTag() {
        Tag tag = new Tag();
        tag.setId(1L);

        repoClientes.altaTag(tag);

        verify(em, times(1)).persist(tag);
    }

    @Test
    void testBajaTag() {
        Tag tag = new Tag();
        tag.setId(1L);
        when(em.find(Tag.class, 1L)).thenReturn(tag);

        repoClientes.bajaTag(1L);

        verify(em, times(1)).remove(tag);
    }

    @Test
    void testModificarTag() {
        Tag tag = new Tag();
        tag.setId(1L);
        Tag existingTag = new Tag();
        existingTag.setId(1L);
        when(em.find(Tag.class, 1L)).thenReturn(existingTag);

        repoClientes.ModificarTag(tag);

        verify(em, times(1)).merge(existingTag);
    }

    @Test
    void testAltaVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);

        repoClientes.altaVehiculo(vehiculo);

        verify(em, times(1)).persist(vehiculo);
    }

    @Test
    void testBajaVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        when(em.find(Vehiculo.class, 1L)).thenReturn(vehiculo);

        repoClientes.bajaVehiculo(1L);

        verify(em, times(1)).remove(vehiculo);
    }

    @Test
    void testModificarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        Vehiculo existingVehiculo = new Vehiculo();
        existingVehiculo.setId(1L);
        when(em.find(Vehiculo.class, 1L)).thenReturn(existingVehiculo);

        repoClientes.modificarVehiculo(vehiculo);

        verify(em, times(1)).merge(existingVehiculo);
    }
}
