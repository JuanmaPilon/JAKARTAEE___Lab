package ModuloComunicacion.Aplicacion;
import ModuloComunicacion.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ModuloComunicacionImpl implements ModuloComunicacionAplicacion {

    @Override
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente) {
        //falta concatenar nombre del cliente, hay que ver como se obtiene
        System.out.println("Notificando saldo insuficiente al cliente " + cliente.getCuentaPREPaga().getNroCuenta());
    }

    @Override
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente) {
        //falta concatenar nombre del cliente, hay que ver como se obtiene
        System.out.println("Notificando tarjeta bloqueada al cliente " + cliente.getCuentaPOSTPaga().getNroCuenta());
    }

    @Override
    public void notificarInformacion(String texto) {
        System.out.println("Notificando información: " + texto);
    }

    @Override
    public ClienteTelepeaje altaCliente(ClienteTelepeaje cliente) {
        System.out.println("Registrando nuevo cliente... ");
        // Lógica para registrar el cliente en el sistema
        return cliente; // Devolver el cliente registrado
    }
}
