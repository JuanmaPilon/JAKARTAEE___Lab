package ModuloPeaje.Aplicacion;
import ModuloPeaje.Dominio.*;

import java.util.List;

public class ModuloPeajeImpl {

    private List<Tag> tagsAutorizados;
    private List<String> matriculasAutorizadas;
    private Comun tarifaComun;

    public boolean estaHabilitado(Identificador identificador) {
        return identificador instanceof Tag || identificador instanceof Matricula;
    }


    public ModuloPeajeImpl() {
        // Inicializa la tarifa común con un monto predeterminado
        double montoPredeterminado = 10.0;
        this.tarifaComun = new Comun(montoPredeterminado);
    }

    public void actualizarTarifaComun(double importe) {
        // Obtiene el importe actual de la tarifa común
        double importeActual = this.tarifaComun.obtenerMonto();
        // Actualiza el importe de la tarifa común con el importe proporcionado
        this.tarifaComun.setMonto(importe);
        //Validación o procesamiento futuro
    }
    public Comun getTarifaComun() {
        return tarifaComun;
    }
}
