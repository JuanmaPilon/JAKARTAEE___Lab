package ModuloSucive.Aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import ModuloSucive.Dominio.*;

@ApplicationScoped
public class ModuloSuciveImpl {
    public void notificarPago(String matricula, double importe) {
        // Lógica para notificar el pago al Sistema externo de Sucive
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La matricula es: " + matricula);
        System.out.println("El importe es: " + importe);
    }
}
