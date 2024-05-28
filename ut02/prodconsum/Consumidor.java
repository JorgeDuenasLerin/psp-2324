package ut02.prodconsum;

public class Consumidor implements Runnable {
    private static final int VECES_CONSUME = 10;
    private static final double EJECUCION_CONCURRENTE = 1000;
    private static final int MIN_EJECUCION_CONCURRENTE = 1000;
    private Almacen almacen;
    private int id;

    public Consumidor(Almacen almacen, int id) {
        this.almacen = almacen;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < VECES_CONSUME; i++) {
            int producto = almacen.extraer();
            
            // Es concurrente
            System.out.println("Consumidor " + id + " ha extraído el producto " + producto);
            try {
                Thread.sleep(MIN_EJECUCION_CONCURRENTE + (int) (Math.random() * EJECUCION_CONCURRENTE));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumidor " + id + " terminó el procesado del producto " + producto);
            // Es concurrente
        }
    }
}