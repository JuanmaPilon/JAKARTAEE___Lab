package ModuloMediosPago.Interface.api;

import ModuloMediosPago.Dominio.ClienteSucive;
import ModuloMediosPago.Dominio.ClienteTelepeaje;
import ModuloMediosPago.Dominio.Tarjeta;

public interface IMediosPago {
    public void CobroTelepeaje(ClienteTelepeaje cli, Tarjeta tar);
    public void CobroSucive(ClienteSucive cli, Tarjeta tar);
}
