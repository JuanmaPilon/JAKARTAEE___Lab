package ModuloSucive.Aplicacion;



import ModuloSucive.Dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class ModuloSucive implements ModuloISucive {


    @Override
    public void notificarPago(Matricula matricula, double importe){
        // Lógica para notificar el pago al Sistema externo de Sucive
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La matricula es: " + matricula.getNroMatricula());
        System.out.println("El importe es: " + importe);
    }

    @Override
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
         List<Pagos> consultaDePagos = new ArrayList<>();
        return consultaDePagos;
        //yo (carlangas) lo hago
    }

    @Override
    public List<Pagos> consultaDePagos(Matricula matricula) {
        //yo (carlangas) lo hago
        //obtengo listaDePagos del repo
        List<Pagos> pagosPorMatricula = new ArrayList<>();
//        for (Pagos pago : listaDePagos) {
//           if (pago.getMatricula().equals(matricula.getNroMatricula())) {
//                pagosPorMatricula.add(pago);
//            }
//        }
        return pagosPorMatricula;
    }

}


