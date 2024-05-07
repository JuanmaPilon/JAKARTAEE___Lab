package ModuloSucive.Aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import ModuloSucive.Dominio.*;
import ModuloSucive.Dominio.Pagos;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;


@ApplicationScoped
public class ModuloSuciveImpl {

    public void notificarPago(String matricula, double importe) {
        // Lógica para notificar el pago al Sistema externo de Sucive
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La matricula es: " + matricula);
        System.out.println("El importe es: " + importe);
    }

    public Set<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal) {
        Set<Pagos> pagosEnRango = new HashSet<>();
        for (Pagos pago : listaDePagos) { // necesito la lista de pagos xd
            Date fechaPago = pago.getFecha();
            if (fechaPago.after(fechaInicial) && fechaPago.before(fechaFinal)) {
                pagosEnRango.add(pago);
            }
        }
        return pagosEnRango;
    }
}
