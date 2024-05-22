package ModuloComunicacion.Aplicacion;

import ModuloComunicacion.Dominio.*;

import java.util.List;

public interface ModuloIComunicacion {
    public void notificarSaldoInsuficiente(ClienteTelepeaje cliente);
    public void notificarTarjetaBloqueada(ClienteTelepeaje cliente);
    public void notificarInformacion(String ci, String texto); // hay que hacer que reciba tambien cliente por que sino no se a quien notificar
    public void altaCliente(ClienteTelepeaje cliente);
    public List<String> obtenerNotiPorCliente(ClienteTelepeaje cliente);
}