package ModuloGestionClientes.Dominio;

import lombok.Getter;
import lombok.Setter;

public class Tag {
	
	@Setter
    @Getter
    String idUnico;


	public Tag() {
		
	}
	
	public Tag(String idUnico) {
		this.idUnico = idUnico;
	}

	@Override
	public String toString() {
		return idUnico;
	}
}



