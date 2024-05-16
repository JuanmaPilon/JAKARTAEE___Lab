package ModuloPeaje.Dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tag {

	private String idUnico;

	public Tag() {

	}

	public Tag(String idUnico) {
		this.idUnico = idUnico;
	}


}
