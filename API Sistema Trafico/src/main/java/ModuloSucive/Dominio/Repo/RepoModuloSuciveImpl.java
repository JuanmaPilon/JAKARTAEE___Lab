package ModuloSucive.Dominio.Repo;



import ModuloSucive.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepoModuloSuciveImpl implements RepoModuloSucive {
    private Map<String, Matricula> matriculasMap;

    public RepoModuloSuciveImpl() {
        matriculasMap = new HashMap<>();
    }

    @Override
    public void altaMatricula(Matricula matricula){
        matriculasMap.put(matricula.getNroMatricula(), matricula);
    }

    @Override
    public Matricula buscarMatricula(String matricula) {
        return matriculasMap.get(matricula);
    }

    @Override
    public Collection<Matricula> obtenerMatriculas() {
        return matriculasMap.values(); //retorna una coleccion de clientes
    }

}
