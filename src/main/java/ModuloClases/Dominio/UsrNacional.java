package ModuloClases.Dominio;

import ModuloGestionClientes.Dominio.ClienteSucive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsrNacional extends Usuario {

    private ClienteSucive clienteSucive;

    public UsrNacional() {};

    public UsrNaciona(Long ci) {
        this.ci = ci; // no me lo toma ni con public ni con protected, capaz es algo de lombok
    }

    }