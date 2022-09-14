package com.josekisystems.hilos.ejemplos;

import com.josekisystems.hilos.runnable.ViajeTarea;

public class InterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

            /*
        Runnable viaje = new Runnable() {
            @Override
            public void run() {
             */

        Thread main = Thread.currentThread();
        Runnable viaje = () ->{
                for(int i = 0; i<10 ; i++){
                    System.out.println(i + " _ " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println("main.getState() = " + main.getState());
            };

        Thread v1 = new Thread(viaje,"Roma");
        Thread v2 = new Thread(viaje,"Florencia");
        Thread v3 = new Thread(viaje,"Venecia");
        Thread v4 = new Thread(viaje,"Milán");
        Thread v5 = new Thread(viaje,"Nápoles");
        Thread v6 = new Thread(viaje,"Roma");
        Thread v7 = new Thread(viaje,"Pisa");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
        v6.start();
        v7.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();
        v5.join();
        v6.join();
        v7.join();

        //Thread.sleep(5000);

        System.out.println("Continuando con la ejecución del metodo main:  " + main.getName());

    }
}
