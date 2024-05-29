package org.tallerjava;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class POSTPagaDTO extends CuentaDTO {

    private double saldo;
    private TarjetaDTO tarjeta;

    public POSTPagaDTO(int nroCuenta,Date fechaApertura, TarjetaDTO tarjeta) {
        super(nroCuenta, fechaApertura);
        this.tarjeta = tarjeta;
    }
}
