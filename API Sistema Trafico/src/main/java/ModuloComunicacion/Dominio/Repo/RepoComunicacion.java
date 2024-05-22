package ModuloComunicacion.Dominio.Repo;
import java.util.Collection;
import ModuloComunicacion.Dominio.*;

public interface RepoComunicacion {
    void altaDatosCliente(ClienteTelepeaje cliente);
    ClienteTelepeaje buscarCliente(String ci);
    Collection<ClienteTelepeaje> obtenerTodosLosClientes();
}
