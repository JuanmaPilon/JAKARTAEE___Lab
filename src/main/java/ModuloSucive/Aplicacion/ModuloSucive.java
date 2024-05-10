package ModuloSucive.Aplicacion;

/*
@ApplicationScoped
public class ModuloSuciveImpl implements ModuloSuciveAplicacion{

    @Override
    public void notificarPago(Matricula matricula, double importe){
        // Lógica para notificar el pago al Sistema externo de Sucive
        System.out.println("Notificando pago al Sistema externo de Sucive");
        System.out.println("La matricula es: " + matricula.getNroMatricula());
        System.out.println("El importe es: " + importe);
    }

    @Override
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

    @Override
    public Set<Pagos> consultaDePagos(Matricula matricula) {
        Set<Pagos> pagosPorMatricula = new HashSet<>();
        for (Pagos pago : listaDePagos) {
           if (pago.getMatricula().equals(matricula.getNroMatricula())) {
                pagosPorMatricula.add(pago);
            }
        }
        return pagosPorMatricula;
    }

}
*/

