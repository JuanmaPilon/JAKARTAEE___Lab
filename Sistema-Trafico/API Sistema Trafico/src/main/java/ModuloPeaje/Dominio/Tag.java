package ModuloPeaje.Dominio;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Setter
@Getter
@Entity(name = "peaje_Tag")
// @Table(name = "peaje_Tag")
public class Tag {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	long id;
	@Id
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
