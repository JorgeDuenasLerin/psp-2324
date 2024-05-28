package ut02.prodconsum;

import java.util.ArrayList;

public class Almacen {
    ArrayList<Integer> almacen = new ArrayList<Integer>();
    int capacidad;

    public Almacen(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void almacenar(int producto) {
        while (almacen.size() == capacidad) {
            try {
                System.out.println("Lo siento el almacén está lleno");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        almacen.add(producto);
        System.out.println("Almacen - Producto almacenado: " + producto);
        notifyAll();
    }

    public synchronized int extraer() {
        if (almacen.size() == 0) {
            try {
                System.out.println("Lo siento el almacén está vacío");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int producto = almacen.remove(0);
        System.out.println("Almacen - Producto extraído: " + producto);
        notifyAll();
        return producto;
    }
}