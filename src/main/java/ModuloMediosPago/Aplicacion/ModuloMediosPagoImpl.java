package ModuloMediosPago.Aplicacion;
import ModuloComunicacion.Aplicacion.ModuloComunicacion;
import ModuloMediosPago.Dominio.*;
import ModuloMediosPago.Dominio.Repo.RepoMediosPago;
import ModuloMediosPago.Dominio.Repo.RepoMediosPagoImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ModuloMediosPagoImpl implements ModuloMediosPagoAplicacion {
    @Inject
    private RepoMediosPago repoMediosPago;
    @Inject
    private ModuloComunicacion moduloComunicacion;

    public ModuloMediosPagoImpl (){
        this.repoMediosPago = new RepoMediosPagoImpl();
        this.moduloComunicacion = new ModuloComunicacion();
    }

    @Override
    public void altaCliente(ClienteTelepeaje cliente, Tarjeta tarjeta) {
        cliente.getCuentaPOSTPaga().setTarjeta(tarjeta); //le asocio la tarjeta a la cuenta postpaga del cliente
        repoMediosPago.altaDatosCliente(cliente); //lo guardo en mi coleccion de clientes correspondiente a este modulo
    }
    @Override
    public void notificarPago(ClienteTelepeaje cliente, Nacional vehiculo, double importe, Tarjeta tarjeta) {
        /* la ci del cliente que llega por parametro debe estar ingresado no solo en este repoMediosPago
        sino tambien en el repo del modulo de comunicacion */
        ClienteTelepeaje clienteModulo = repoMediosPago.buscarCliente(cliente.getCi()); // busco el cliente que esta ingresado en el repo mediante el que se me provee
        String texto = "Nuevo pago por el importe de :" + importe + " Matricula: "+ vehiculo.getMatricula().getNroMatricula() +" Tarjeta: "+ tarjeta.getNombre(); //creo la notificacion
        moduloComunicacion.notificarInformacion(cliente.getCi(),texto);// le derivo la tarea de la notificacion al modulo correspondiente
    }

    @Override
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
        //1- Recorro lista de clientes del repo
        //2- obtengo todos los pagos de cada cliente que esten entre las fechas dadas y los voy guardando en orden
        //3- retorno la lista de pagos
        return List.of();
    }
    @Override
    public List<Pagos> consultaDePagos(ClienteTelepeaje cliente){
        //1- busco al cliente en el repo
        //2- obtengo su lista de pagos y la retorno
        return List.of();
    }

    @Override
    public List<Pagos> consultaDePagos(ClienteTelepeaje cliente, Vehiculo vehiculo) {
        //1- busco al cliente en el repo
        //2- obtengo su lista de pagos, la recorro y me quedo solo con los pagos que se correspondan a la matricula del vehiculo por parametro
        //3- retorno nueva lista
        return List.of();
    }

}
