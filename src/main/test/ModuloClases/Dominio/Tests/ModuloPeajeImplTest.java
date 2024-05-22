package ModuloClases.Dominio.Tests;

import ModuloPeaje.Aplicacion.ModuloPeajeImpl;
import ModuloPeaje.Evento.PublicadorEventoPeaje;
import ModuloPeaje.Evento.notificarPasajeVehiculo;
import jakarta.enterprise.event.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class ModuloPeajeImplTest {

    @Mock
    private PublicadorEventoPeaje publicadorEventoPeaje;

    @Mock
    private Event<notificarPasajeVehiculo> event;

    @InjectMocks
    private ModuloPeajeImpl moduloPeaje;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Captor
    ArgumentCaptor<notificarPasajeVehiculo> captor;

    @Test
    public void manejarNotificarPasajeVehiculoTest() {
        MockitoAnnotations.openMocks(this);
        String mensajeVehiculo = "Pasaje de vehículo detectado";

        moduloPeaje.manejarNotificarPasajeVehiculo();

        verify(publicadorEventoPeaje).publicarPasajeVehiculo(mensajeVehiculo);
        // verify(event).fire(captor.capture());

        // notificarPasajeVehiculo evento = captor.getValue();
        // assertEquals(mensajeVehiculo, evento.getDescripcion());
    }
}