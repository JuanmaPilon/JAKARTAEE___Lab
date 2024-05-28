package ModuloGestionClientes.Dominio;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Setter
@Getter
@Entity(name = "gestion_Tag")
// @Table(name = "gestion_Tag")
public class Tag {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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



