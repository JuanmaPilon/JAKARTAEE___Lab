package org.tallerjava;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TagDTO {

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



