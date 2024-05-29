package org.tallerjava;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
// cambie por data que ya incluye setters , getters, pareses y to string y otras cosas.

@Data
public class ClienteTelepeajeDTO {
    private String ci;
    private String nombre;
    private String email;
    private Double saldo;

    private PREPaga cuentaPrepaga; // Cuenta de tipo PREPaga

    private POSTPaga cuentaPostpaga; // Cuenta de tipo POSTPaga

    private Tarjeta tarjeta;

    private List<PasadaPorPeaje> pasadaPorPeaje;

    private List<Vehiculo> vehiculosCliente;

    public ClienteTelepeajeDTO() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
        this.cuentaPrepaga = null;
        this.cuentaPostpaga = null;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public ClienteTelepeajeDTO(String nombre, String ci,String email, List<Vehiculo> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.email = email;
        this.vehiculosCliente = vehiculosCliente;
        this.saldo = 0.0;
        this.cuentaPrepaga = null;
        this.cuentaPostpaga = null;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public void agregarVehiculoACliente(VehiculoDTO vehiculo) {
        this.vehiculosCliente.add(vehiculo);
    }

    public void asignarCuentaPrepaga(PREPagaDTO cuenta) {
        this.cuentaPrepaga = cuenta;
    }

    public void asignarCuentaPostpaga(POSTPagaDTO cuenta) {
        this.cuentaPostpaga = cuenta;
    }

    public void cargarSaldo(Double importe) {
        this.saldo += importe;
    }

    public Double consultarSaldo() {
        return this.saldo;
    }

    public void asociarTarjeta(TarjetaDTO tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<PasadaPorPeajeDTO> getPasadasPorPeaje() {
        return this.pasadaPorPeaje;
    }

    public List<PasadaPorPeajeDTO> getPasadasEnRango(Date fechaInicio, Date fechaFin) {
        List<PasadaPorPeajeDTO> pasadasEnRango = new ArrayList<>();
        for (PasadaPorPeajeDTO pasada : this.pasadaPorPeaje) {
            if (!pasada.getFecha().before(fechaInicio) && !pasada.getFecha().after(fechaFin)) {
                pasadasEnRango.add(pasada);
            }
        }
        return pasadasEnRango;
    }
}


