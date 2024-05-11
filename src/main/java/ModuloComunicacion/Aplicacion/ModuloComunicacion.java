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
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente) {
        System.out.println("Notificando saldo insuficiente al cliente atravez de email: " + cliente.getEmail());//le aviso
        cliente.agregarNotificacion("NOTIFICACION: saldo insuficiente.");//guardo la notificacion
    }

    @Override
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente) {
        System.out.println("Notificando tarjeta bloqueada al cliente atravez de email: " + cliente.getEmail());
        cliente.agregarNotificacion("NOTIFICACION: tarjeta bloqueada.");
    }

    @Override
    public void notificarInformacion(ClienteTelepeaje cliente, String texto) {
        System.out.println("Notificando al cliente : NOTIFICACION: " + texto);
        repoComunicacion.buscarCliente(cliente.getCi()).agregarNotificacion("NOTIFICACION: " + texto);  //le agrego la notificacion al cliente
    }

    @Override
    public List<String> obtenerNotiPorCliente(ClienteTelepeaje cliente) {
        return repoComunicacion.buscarCliente(cliente.getCi()).getNotificaciones();
    }

}
