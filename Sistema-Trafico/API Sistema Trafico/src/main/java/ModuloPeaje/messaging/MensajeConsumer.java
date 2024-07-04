package ModuloPeaje.messaging;


import ModuloGestionClientes.Aplicacion.ModuloIGestionClientes;
import ModuloPeaje.Dominio.Comun;
import ModuloSucive.Aplicacion.ModuloSucive;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.Data;
import org.jboss.logging.Logger;

import java.util.Date;
import java.util.NoSuchElementException;

import ModuloGestionClientes.Dominio.Repo.RepoClientes;
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "jakarta.jms.Queue"),
                @ActivationConfigProperty(
                        propertyName = "destinationLookup",
                        propertyValue = "java:app/jms/ServicioPagoQueue"),
                @ActivationConfigProperty
                        (propertyName = "maxSession", propertyValue = "1")
        }
)
@Data
@ApplicationScoped
public class MensajeConsumer implements MessageListener {

        private static final Logger log = Logger.getLogger(MensajeConsumer.class);


        public MensajeConsumer () {}

        @Inject
        private ModuloIGestionClientes moduloIGestionClientes;

        @Inject
        private ModuloSucive moduloSucive;

        @Inject
        private RepoClientes repoGestion;

        @Inject
        private EnviarMensajeQueue enviarMensajeQueue;

        @Override
        public void onMessage(Message message) {

                try {
                        String body = message.getBody(String.class);
                        RealizadoMessage realizadoMessage = RealizadoMessage.readFromJson(body);
                        log.infof("Nuevo proceso de nacional: %s, body: %s", message.toString(),
                                body);
                        // Extraer datos de RealizadoMessage
                        String tag = realizadoMessage.getTag();
                        Long idVehiculo = realizadoMessage.getVehiculo();
                        String matricula = realizadoMessage.getMatricula();


                        boolean habilitado = false;
                        Comun tarifa = new Comun(70);
                        habilitado = moduloIGestionClientes.realizarPrePago(tag, tarifa.getMonto());
                        if(!habilitado) {
                                habilitado = moduloIGestionClientes.realizarPostPago(tag,tarifa.getMonto());
                        } if(!habilitado) {
                                habilitado = true;
                                moduloSucive.notificarPago(matricula, tarifa.getMonto());
                        }
                        Date fechaActual = new Date();
                        repoGestion.altaPasadaPorPeaje(tarifa.getMonto(),fechaActual,idVehiculo);

                         }  catch (JMSException e) {
                        System.err.printf("Error (de tipo %s): %s\n", e.getClass(), e.getMessage());

                } catch (NoSuchElementException e){
                        System.err.printf("Error (en clase %s): No se encontro el Vehiculo", this.getClass());
                }
        }
}
