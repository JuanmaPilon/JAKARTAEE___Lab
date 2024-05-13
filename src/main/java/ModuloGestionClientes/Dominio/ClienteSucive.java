package ModuloGestionClientes.Dominio;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteSucive {

    private String nombre;
    public String ci;
    private List<Vehiculo> vehiculosVinculados;

    public ClienteSucive() {
        this.vehiculosVinculados = new ArrayList<>();
    }

    public ClienteSucive(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
        this.vehiculosVinculados = new ArrayList<>();
    }


    public void agregarVehiculoVinculado(Vehiculo vehiculo) {
        this.vehiculosVinculados.add(vehiculo);
    }

    public void eliminarVehiculoVinculado(Vehiculo vehiculo) {
        this.vehiculosVinculados.remove(vehiculo);
    }

    public List<Vehiculo> getVehiculosVinculados() {
        return this.vehiculosVinculados;
    }

}
