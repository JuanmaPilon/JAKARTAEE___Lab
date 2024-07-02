package org.tallerjava;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DatosConsultaPasadaDTO implements Serializable {
    String tag;
    Date fechaInicio;
    Date fechaFin;
    String cedula;
}
