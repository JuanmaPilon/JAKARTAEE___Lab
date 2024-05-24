package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@Entity

@Table(name = "peaje_vehiculoNacional")
@PrimaryKeyJoinColumn(name = "id")
public class Nacional extends Vehiculo {

	@OneToOne(cascade = CascadeType.ALL)
	private Matricula matricula;
	@OneToOne(cascade = CascadeType.ALL)
	private Tag tag;

	public Nacional() {

	}

	public Nacional(Matricula matricula, Tag tag) {
		super();
		this.matricula = matricula;
		this.tag = tag;
	}


}