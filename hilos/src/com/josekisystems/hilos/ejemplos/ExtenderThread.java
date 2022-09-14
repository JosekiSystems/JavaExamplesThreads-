package com.josekisystems.hilos.ejemplos;

import com.josekisystems.hilos.threads.NombreThread;

public class ExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        
        Thread hilo = new NombreThread("Roro Lacrau");
        hilo.start();
       /*
       Thread.sleep(100);       //para mostrar como se ejecuta el hilo con una pausa en el main
       */

        Thread hilo2 = new NombreThread("Bibi Lacrau");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Laika Lacrau");
        hilo3.start();

        System.out.println("hilo.getState() = " + hilo.getState());
        
    }
}
