package ModuloComunicacion.Aplicacion;
import ModuloComunicacion.Dominio.*;
import ModuloComunicacion.Dominio.Repo.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ModuloComunicacion implements ModuloIComunicacion {

    @Inject
    private RepoComunicacion repoComunicacion;

    public ModuloComunicacion() {
        this.repoComunicacion = new RepoComunicacionImpl();
    }
    @Override
    public void altaCliente(ClienteTelepeaje cliente) {
        System.out.println("Registrando nuevo cliente: " + cliente.getNombre());
        repoComunicacion.altaDatosCliente(cliente);//guardo el cliente en mi lista de clientes
    }

    @Override
    public void notificarSaldoInsuficiente(String email) {
        System.out.println("Notificando saldo insuficiente al cliente atravez de email: " + email);//le aviso
    }

    @Override
    public void notificarTarjetaBloqueada(String email) {
        System.out.println("Notificando tarjeta bloqueada al cliente atravez de email: " + email);
    }

    @Override
    public void notificarInformacion(String ci, String texto) {
        System.out.println("Notificando al cliente : NOTIFICACION: " + texto);
        ClienteTelepeaje cliente = repoComunicacion.buscarCliente(ci);
        repoComunicacion.buscarCliente(ci).agregarNotificacion("NOTIFICACION: " + texto);  //le agrego la notificacion al cliente
    }

    @Override
    public List<String> obtenerNotiPorCliente(ClienteTelepeaje cliente) {
        return repoComunicacion.buscarCliente(cliente.getCi()).getNotificaciones();
    }

}
