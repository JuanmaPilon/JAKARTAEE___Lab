package ModuloSucive.Aplicacion;


import ModuloSucive.Dominio.*;
import ModuloSucive.Dominio.Repo.*;
import ModuloSucive.Evento.PublicadorEventoSucive;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ModuloSucive implements ModuloISucive {
    @Inject
    private PublicadorEventoSucive pagoSucive;

    @Inject
    private RepoModuloSucive repoModuloSucive;

    public ModuloSucive() {
        this.repoModuloSucive = new RepoModuloSuciveImpl();
    }

    @Override
    public void notificarPago(Matricula matricula, double importe){
        // Lógica para notificar el pago al Sistema externo de Sucive
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La matricula es: " + matricula.getNroMatricula());
        System.out.println("El importe es: " + importe);
        String mensajeSucive = "Pago realizado con Sucive: " +
                "La matricula es: " + matricula.getNroMatricula() +
                ". El importe es: " + importe;
        pagoSucive.publicarPagoSucive(mensajeSucive);
    }

    @Override
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
        List<Pagos> pagosEntreFechas = new ArrayList<>();//creo la nueva lista
        for (Matricula matricula : repoModuloSucive.obtenerMatriculas()) { //recorro lista de Matriculas (son todos los vehiculos nacionales)
            for (Pagos pago : matricula.getPagos()) {  //recorro pagos de cada cliente
                if(pago.getFecha().after(fechaInicial) && pago.getFecha().before(fechaFinal)) { //me aseguro que el pago corresponda a las fechas
                    pagosEntreFechas.add(pago);  //lo agrego a la nueva lista
                }
            }
        }
        pagosEntreFechas.sort((pago1, pago2) -> pago1.getFecha().compareTo(pago2.getFecha())); // supuestamente ordena la lista de pagos por fechas
        return pagosEntreFechas; //retorno los pagos
    }

    @Override
    public List<Pagos> consultaDePagos(Matricula matricula) {
        //obtengo listaDePagos del repo y la retorno
        return matricula.getPagos();
    }

}


