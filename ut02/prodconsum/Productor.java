package ut02.prodconsum;

public class Productor implements Runnable {
    private static final int VECES_PRODUCE = 10;
    private static final double TIEMPO_EN_PRODUCIR = 2000;
    private static final double MAX_NUMERO_PRODUCTO = 100;
    private Almacen almacen;
    private int id;

    public Productor(Almacen almacen, int id) {
        this.almacen = almacen;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < VECES_PRODUCE ; i++) {
            // Es concurrente
            System.out.println("Productor " + id + " comienza producción");
            try {
                Thread.sleep((int) (Math.random() * TIEMPO_EN_PRODUCIR));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int producto = (int) (Math.random() * MAX_NUMERO_PRODUCTO);
            System.out.println("Productor " + id + " ha finalizado la producción. Ha producido el producto " + producto);
            // Es concurrente

            almacen.almacenar(producto);
            System.out.println("Productor " + id + " ha almacenado el producto " + producto);
            
        }
    }
}