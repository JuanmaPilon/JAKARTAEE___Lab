package org.tallerjava;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class TarjetaDTO implements Serializable {
    private int nro;

    private String nombre;

    private Date fechaVto;

    public TarjetaDTO(int nro, String nombre, Date fechaVto) {
        this.nro = nro;
        this.nombre = nombre;
        this.fechaVto = fechaVto;
    }

    public void setFechaVencimiento(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

}