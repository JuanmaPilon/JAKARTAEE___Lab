package org.tallerjava;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Data
public class IdentificadorDTO implements Serializable {
    private String  matricula;
    private int tag;
}
