package ModuloComunicacion.Aplicacion;
import ModuloComunicacion.Dominio.*;
import ModuloComunicacion.Dominio.Repo.RepoComunicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ModuloComunicacionImpl implements ModuloComunicacionAplicacion {

    @Inject
    private RepoComunicacion repoComunicacion;

    @Override
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente) {
        String email = repoComunicacion.buscarMailCliente(cliente.getCi());
        System.out.println("Notificando saldo insuficiente al cliente atravez de email:" + email);
    }

    @Override
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente) {
        String email = repoComunicacion.buscarMailCliente(cliente.getCi());
        System.out.println("Notificando tarjeta bloqueada al cliente atravez de email: " + email);
    }

    @Override
    public void notificarInformacion(String texto) {
        //tengo que avisarle a todos los clientes, ver como
        System.out.println("Notificando información: " + texto);
    }

    @Override
    public void altaCliente(ClienteTelepeaje cliente, String email) {
        System.out.println("Registrando nuevo cliente: " + cliente.getNombre());
        repoComunicacion.altaDatosCliente(cliente,email);
    }

    //falta oper que devuelve todas las notificaciones de un cliente
}
