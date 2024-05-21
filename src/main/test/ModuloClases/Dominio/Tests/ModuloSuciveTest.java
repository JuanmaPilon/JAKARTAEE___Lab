package ModuloClases.Dominio.Tests;

import ModuloSucive.Aplicacion.ModuloSucive;
import ModuloSucive.Dominio.Matricula;
import ModuloSucive.Evento.PublicadorEventoSucive;
import ModuloMonitoreo.Aplicacion.ModuloMonitoreo;
import ModuloSucive.Evento.notificarPagoSucive;
import jakarta.enterprise.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModuloSuciveTest {
    @InjectMocks
    private ModuloSucive modulo;

    @Mock
    private PublicadorEventoSucive publicadorEventoSucive;

    @Mock
    private Event<notificarPagoSucive> pagoSuciveEvent;

    @Mock
    private ModuloMonitoreo moduloMonitoreo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Use doAnswer for void methods
        doAnswer(invocation -> {
            String mensaje = invocation.getArgument(0);
            pagoSuciveEvent.fire(new notificarPagoSucive(mensaje));
            return null;
        }).when(publicadorEventoSucive).publicarPagoSucive(anyString());

        doAnswer(invocation -> {
            notificarPagoSucive event = invocation.getArgument(0);
            moduloMonitoreo.notificarCobroSucive(event);
            return null;
        }).when(pagoSuciveEvent).fire(any(notificarPagoSucive.class));
    }

    @Test
    public void testNotificarPago() {
        // Arrange
        Matricula mat = new Matricula("ABCD123");
        double importe = 500;
        String mensajeEsperado = "Pago realizado con Sucive: " +
                "La matricula es: " + mat.getNroMatricula() +
                ". El importe es: " + importe;

        // Act
        modulo.notificarPago(mat, importe);

        // Assert
        ArgumentCaptor<notificarPagoSucive> eventCaptor = ArgumentCaptor.forClass(notificarPagoSucive.class);
        verify(pagoSuciveEvent).fire(eventCaptor.capture());
        assertEquals(mensajeEsperado, eventCaptor.getValue().getDescripcion());

        // Verificar que se haya llamado a notificarCobroSucive con el mensaje esperado
        verify(moduloMonitoreo).notificarCobroSucive(eventCaptor.getValue());
    }
    // como pruebo las otras operaciones del modulo si supuestamente este modulo no tiene ninguna operacion de alta ???
    

}
