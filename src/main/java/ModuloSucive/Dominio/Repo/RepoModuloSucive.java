package ModuloSucive.Dominio.Repo;
import java.util.Collection;
import ModuloSucive.Dominio.*;
public interface RepoModuloSucive {
    // tiene que ser un repo de objetos matricula, cada matricula tiene que tener una coleccion de pagos y su numero de matricula (falta agregar matricula al dominio de este modulo)

    // alta de matricula en el repo
    void altaMatricula(Matricula matricula);
    // buscar matricula por numero
    Matricula buscarMatricula(String matricula);
    // obtener todas las matriculas (esto servira para obtener toda la coleccion de pagos corresponientes a un numero de matricula)
    Collection<Matricula> obtenerMatriculas();
}
