package ModuloComunicacion.Dominio.Repo;

import ModuloComunicacion.Dominio.*;

public interface RepoComunicacion {
    void altaDatosCliente(ClienteTelepeaje cliente,String email); //nombre e email de un cliente para despues poder avisarle
    String buscarMailCliente(String ci);
    // necesito ademas almacenar todas las notificaciones para cada cliente
    // void nuevaNotificacion(ClienteTelepeaje cliente,String notificacion);// guarda una nueva notificacion para un cliente determinado
    // y necesito otra oper para que obtenga todas las notificaciones de un cliente
}
