package ModuloPeaje.Aplicacion;
import ModuloPeaje.Dominio.*;

import java.util.List;

public class ModuloPeajeImpl {

    private Comun tarifaComun;
    private Preferencial tarifaPreferencial;

    public boolean estaHabilitado(Identificador identificador) {
        return identificador instanceof Tag || identificador instanceof Matricula;
    }


    public ModuloPeajeImpl() {
        // Inicializa la tarifa común con un monto predeterminado
        double montoPredeterminado = 10.0;
        this.tarifaComun = new Comun(montoPredeterminado);
        // Inicializa la tarifa Preferencial con un monto predeterminado
        double montoPredeterminadoPreferencial = 5.0;
        this.tarifaPreferencial = new Preferencial(montoPredeterminadoPreferencial);
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

    public void actualizarTarifaPreferencial(double importe) {
        // Obtiene la tarifa preferencial actual
        double importeActual = this.tarifaPreferencial.obtenerMontoPreferencial();

        // Actualiza el importe de la tarifa preferencial con el importe proporcionado
        this.tarifaPreferencial.setMonto(importe);

        //Validación o procesamiento futuro
    }

    public Preferencial getTarifaPreferencial() {
        return tarifaPreferencial;
    }

}
