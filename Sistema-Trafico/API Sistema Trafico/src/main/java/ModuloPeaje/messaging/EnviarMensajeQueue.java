package ModuloPeaje.messaging;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import org.jboss.logging.Logger;
import ModuloPeaje.Aplicacion.*;

import ModuloPeaje.Dominio.*;

@ApplicationScoped
public class EnviarMensajeQueue {

    Logger log = Logger.getLogger(ModuloPeajeImpl.class);

    @Inject
    private JMSContext jmsContext;
    @Resource(lookup = "java:jboss/exported/jms/queue/servicioPago")
    private Queue queue;


    public void sendMessage(String tag, Long vehiculo, String matricula){
        RealizadoMessage realizadoMessage = new RealizadoMessage(tag, vehiculo, matricula);
        jmsContext.createProducer().send(queue, realizadoMessage.toJson());
    }
}
