package ModuloComunicacion.Aplicacion;

import ModuloComunicacion.Dominio.*;

public interface ModuloIComunicacion {
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente);
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente);
    public void notificarInformacion(String texto);
    public void altaCliente(ClienteTelepeaje cliente, String email);// hago que tambien reciba email para asi poder notificarlo en este modulo
    //obtenerNotiPorCliente(ClienteTelepeaje cliente):set(Notificaciones);

}