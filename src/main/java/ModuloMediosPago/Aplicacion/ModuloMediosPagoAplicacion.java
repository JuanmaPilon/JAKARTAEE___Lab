package ModuloMediosPago.Aplicacion;
import java.util.Date;
import java.util.List;


import ModuloMediosPago.Dominio.*;

public interface ModuloMediosPagoAplicacion {
	public void altaCliente(ClienteTelepeaje cliente, Tarjeta tarjeta);// es cliente telepeaje ??
	public void notificarPago(ClienteTelepeaje cliente, Nacional vehiculo, double importe, Tarjeta tarjeta);
    public List<Pagos> consultaDePagos(Date fechaInicial, Date fechaFinal);
	public List<Pagos> consultaDePagos(ClienteTelepeaje cliente);
	public List<Pagos> consultaDePagos(ClienteTelepeaje cliente, Nacional vehiculo);
}
