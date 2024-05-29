package org.tallerjava;

import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.tallerjava.*;

@Data
public class ClienteSuciveDTO {
    private String ci;
    private String nombre;
    private Double saldo;


    private List<VehiculoDTO> vehiculosCliente;

    private TarjetaDTO tarjeta;

    private List<PasadaPorPeajeDTO> pasadaPorPeaje;

    public ClienteSuciveDTO() {
        this.vehiculosCliente = new ArrayList<>();
        this.saldo = 0.0;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public ClienteSuciveDTO(String nombre, String ci, List<VehiculoDTO> vehiculosCliente) {
        this.nombre = nombre;
        this.ci = ci;
        this.vehiculosCliente = vehiculosCliente;
        this.saldo = 0.0;
        this.tarjeta = null;
        this.pasadaPorPeaje = new ArrayList<>();
    }

    public void agregarVehiculoACliente(VehiculoDTO vehiculo) {
        this.vehiculosCliente.add(vehiculo);
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
