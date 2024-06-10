package ModuloMediosPago.Interface.api;

import ModuloMediosPago.Dominio.ClienteSucive;
import org.tallerjava.ClienteTelepeajeDTO;
import org.tallerjava.TarjetaDTO;

public interface IMediosPago {
    public void CobroTelepeaje(ClienteTelepeajeDTO cli, TarjetaDTO tar);
    //public void CobroSucive(ClienteSucive cli, Tarjeta tar);
}
