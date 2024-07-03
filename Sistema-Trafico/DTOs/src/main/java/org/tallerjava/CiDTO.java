package org.tallerjava;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CiDTO implements Serializable {
    String ci;

    public CiDTO() {
    }

    public CiDTO(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return ci;
    }
}