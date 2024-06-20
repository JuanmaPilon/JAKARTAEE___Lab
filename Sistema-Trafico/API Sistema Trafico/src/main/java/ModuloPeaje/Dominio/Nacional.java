package ModuloPeaje.Dominio;

import ModuloPeaje.Dominio.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;
@Setter
@Getter
@Entity(name = "peaje_vehiculoNacional")
// @Table(name = "peaje_vehiculoNacional")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Nacional extends Vehiculo {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matricula_id", referencedColumnName = "id")
	private Matricula matricula;

	@Column(name = "nroMatricula")
	private String nroMatricula;

	public Nacional(Matricula matricula, Tag tag) {
		super(tag);
		this.matricula = matricula;

	}
	public Nacional(Matricula matricula, Tag tag, String tag_idUnico) {
		super(tag, tag_idUnico);
		this.matricula = matricula;

	}
	public Nacional(Matricula matricula, Tag tag, String tag_idUnico, String nroMatricula) {
		super(tag, tag_idUnico);
		this.matricula = matricula;
		this.nroMatricula = nroMatricula;
	}



}