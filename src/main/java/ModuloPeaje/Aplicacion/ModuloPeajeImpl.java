package ModuloPeaje.Aplicacion;
import ModuloPeaje.Dominio.*;

import java.util.List;

public class ModuloPeajeImpl {

    private List<Tag> tagsAutorizados;
    private List<String> matriculasAutorizadas;

    // Constructor para inicializar las listas de tags y matrículas autorizadas (simulación de datos en memoria)
    //public ModuloPeajeImpl() {
       // this.tagsAutorizados = obtenerTagsAutorizados();
       // this.matriculasAutorizadas = obtenerMatriculasAutorizadas();
    //}

    public boolean estaHabilitado(Identificador identificador) {
        return identificador instanceof Tag || identificador instanceof Matricula;
    }

}
