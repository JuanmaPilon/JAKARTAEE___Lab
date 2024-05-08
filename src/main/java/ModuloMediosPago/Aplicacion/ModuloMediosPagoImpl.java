package ModuloMediosPago.Aplicacion;
import ModuloMediosPago.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ModuloMediosPagoImpl implements ModuloMediosPagoAplicacion {

    @Override
    public void altaCliente(ClienteTelepeaje cliente, Tarjeta tarjeta) {
    // creo que tengo que agarrar el cliente y asociarle una postpaga y a postpaga asociarle una tarjeta por que sino no tiene sentido esta operacion en este modulo
        cliente.getCuentaPOSTPaga().setTarjeta(tarjeta); //le asocio la tarjeta a la cuenta postpaga del cliente
        System.out.println("se asocio el cliente a su tarjeta");//simple flag de referencia
    }
    @Override
    public void notificarPago(ClienteTelepeaje cliente, Nacional vehiculo, double importe, Tarjeta tarjeta) {
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La Matricula es: " + vehiculo.getMatricula().getNroMatricula());
        System.out.println("El importe es: " + importe);
        System.out.println("La Tarjeta es: " + tarjeta.getNombre());
    }
    @Override
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
        //proximamente solo en cines
        return List.of();
    }

    @Override
    public List<Pagos> consultaDePagos(Usuario cliente, Vehiculo vehiculo) {
        //proximamente solo en cines
        return List.of();
    }

}
