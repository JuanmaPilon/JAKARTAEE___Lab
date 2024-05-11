package ModuloComunicacion.Aplicacion;

import ModuloComunicacion.Dominio.*;

import java.util.List;

public interface ModuloIComunicacion {
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente);
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente);
    public void notificarInformacion(String texto);
    public void altaCliente(ClienteTelepeaje cliente);// hago que tambien reciba email para asi poder notificarlo en este modulo
    public List<String> obtenerNotiPorCliente(ClienteTelepeaje cliente);
}