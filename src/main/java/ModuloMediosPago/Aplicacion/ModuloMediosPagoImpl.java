package ModuloMediosPago.Aplicacion;
import ModuloComunicacion.Aplicacion.ModuloComunicacion;
import ModuloMediosPago.Dominio.*;
import ModuloMediosPago.Dominio.Repo.RepoMediosPago;
import ModuloMediosPago.Dominio.Repo.RepoMediosPagoImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import ModuloComunicacion.Aplicacion.ModuloComunicacion;
import jakarta.inject.Inject;

import java.util.*;

@ApplicationScoped
public class ModuloMediosPagoImpl implements ModuloMediosPagoAplicacion {
    @Inject
    private Event<String> eventoPago;
    @Inject
    private RepoMediosPago repoMediosPago;
    @Inject
    private ModuloComunicacion moduloComunicacion;

    @Inject
    public ModuloMediosPagoImpl (ModuloComunicacion moduloComunicacion){
        this.repoMediosPago = new RepoMediosPagoImpl();
        this.moduloComunicacion = moduloComunicacion;
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
        moduloComunicacion.notificarInformacion(clienteModulo.getCi(),texto);// le derivo la tarea de la notificacion al modulo correspondiente (ver como hacer con eventos)
        eventoPago.fire(texto); // Notifica al modulo de monitoreo
    }

    @Override
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
        //1- Recorro lista de clientes del repo
        //2- obtengo todos los pagos de cada cliente que esten entre las fechas dadas y los voy guardando en orden
        //3- retorno la lista de pagos
        List<Pagos> pagosEntreFechas = new ArrayList<>();//creo la nueva lista
        for (ClienteTelepeaje cliente : repoMediosPago.obtenerTodosLosClientes()) { //recorro lista clientes
            for (Pagos pago : cliente.getPagos()) {  //recorro pagos de cada cliente
                if(pago.getFecha().after(fechaInicial) && pago.getFecha().before(fechaFinal)) { //me aseguro que el pago corresponda a las fechas
                    pagosEntreFechas.add(pago);  //lo agrego a la nueva lista
                }
            }
        }
        pagosEntreFechas.sort((pago1, pago2) -> pago1.getFecha().compareTo(pago2.getFecha())); // supuestamente ordena la lista de pagos por fechas
        return pagosEntreFechas; //retorno los pagos
    }

    @Override
    public List<Pagos> consultaDePagos(ClienteTelepeaje cliente){ //todo bien
        //1- busco al cliente en el repo
        //2- obtengo su lista de pagos y la retorno
        return repoMediosPago.buscarCliente(cliente.getCi()).getPagos();
    }

    @Override
    public List<Pagos> consultaDePagos(ClienteTelepeaje cliente, Nacional vehiculo) {
        //1- busco al cliente en el repo
        //2- obtengo su lista de pagos, la recorro y me quedo solo con los pagos que se correspondan a la matricula del vehiculo por parametro
        //3- retorno nueva lista
        List<Pagos> pagosVehiculoConcreto = new ArrayList<>();
        for (Pagos pago : repoMediosPago.buscarCliente(cliente.getCi()).getPagos()) {
            if (Objects.equals(pago.getMatricula(), vehiculo.getMatricula().getNroMatricula())){
                pagosVehiculoConcreto.add(pago);
            }
        }
        return pagosVehiculoConcreto;  //si no hay pagos con esa matricula esto se retorna vacio
    }

}
