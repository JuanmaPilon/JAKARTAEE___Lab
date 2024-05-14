package ModuloClases.Dominio.Tests;


import ModuloSucive.Aplicacion.ModuloSucive;
import ModuloSucive.Dominio.*;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

public class ModuloSuciveTest {
    @Inject
    private ModuloSucive modulo;

    public ModuloSuciveTest() {
        this.modulo = new ModuloSucive();
    }

    @Test
    public void testNotificarPago() {
        Matricula mat = new Matricula("ABCD123");
        //pruebo notiifcar pago
        modulo.notificarPago(mat,500);
    }


    // como pruebo las otras operaciones del modulo si supuestamente este modulo no tiene ninguna operacion de alta ???
    

}
