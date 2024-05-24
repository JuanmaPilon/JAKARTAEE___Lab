package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.Tag;
import ModuloPeaje.Dominio.Vehiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "peaje_vehiculoExtranjero")
@PrimaryKeyJoinColumn(name = "id")
public class Extranjero extends Vehiculo {

	@OneToOne(cascade = CascadeType.ALL)
	private Tag tag;


	public Extranjero(Tag tag) {
		super();

		this.tag = tag;
	}

}
