package ramelimiter;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;

public class ToketBucketMain {
    private Bucket bucket;
    private int contador = 0;

    public ToketBucketMain() {
        Bandwidth bucketConf = Bandwidth.builder().capacity(10).refillGreedy(10, Duration.ofMinutes(1)).build();
        this.bucket = Bucket.builder().addLimit(bucketConf).build();

        startProcess();
    }

    private void startProcess() {
        while (contador < 100) {
            hacerAlgo("accion " + contador);
            hacerPausa(1000); // cada un segundo emito una nueva acción
        }

        // las primeras diez acciones no tienen problema ya que el balde tiene tokens
        // una vez que se consumen los tokens, se agregará uno nuevo cada 6 segundos aprox
    }

    private void hacerAlgo(String accion) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        incrementarContador();
        Runnable hilo = () -> {
            boolean consumido = bucket.tryConsume(1);
            if (consumido) {
                System.out.println("Realizando: " + accion + ", " + formatter.format(new Date()));
                hacerPausa(500);
            } else {
                System.out.println("No realizando: " + accion);
            }
        };
        new Thread(hilo).start();
    }

    private void hacerPausa(int pausa) {
        try {
            Thread.sleep(pausa);
        } catch (InterruptedException e) {
            // Handle the exception, for example by restoring the interrupt status
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private synchronized void incrementarContador() {
        contador++;
    }

//    public static void main(String[] args) {
//        // This can be removed or used to trigger the process
//        new ToketBucketMain();
//    }
}




