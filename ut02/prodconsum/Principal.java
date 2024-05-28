package ut02.prodconsum;

public class Principal {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(10);

        Productor p1 = new Productor(almacen, 1);
        Productor p2 = new Productor(almacen, 2);
        Consumidor c1 = new Consumidor(almacen, 1);
        //Consumidor c2 = new Consumidor(almacen, 2);

        Thread[] hilos = new Thread[3];
        hilos[0] = new Thread(p1);
        hilos[1] = new Thread(p2);
        hilos[2] = new Thread(c1);
        //hilos[3] = new Thread(c2);

        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
