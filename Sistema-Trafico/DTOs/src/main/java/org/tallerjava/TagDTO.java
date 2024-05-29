package org.tallerjava;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class TagDTO implements Serializable {

    String idUnico;
	public TagDTO() {
	}
	
	public TagDTO(String idUnico) {
		this.idUnico = idUnico;
	}

	@Override
	public String toString() {
		return idUnico;
	}
}



