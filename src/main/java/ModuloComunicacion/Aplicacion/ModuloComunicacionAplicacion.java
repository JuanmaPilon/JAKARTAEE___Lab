package ModuloComunicacion.Aplicacion;

import ModuloComunicacion.Dominio.*;

public interface ModuloComunicacionAplicacion {
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente);
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente);
    public void notificarInformacion(String texto);
    public ClienteTelepeaje altaCliente(ClienteTelepeaje cliente);
    // obtenerNotiPorCliente(ClienteTelepeaje cliente):set(Notificaciones);

}