package com.josekisystems.hilos.ejemplos.sync;

import com.josekisystems.hilos.ejemplos.sync.runnable.Consumidor;
import com.josekisystems.hilos.ejemplos.sync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class ProductorConsumidorJava8 {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();
        
        new Thread(() -> {
            for(int i = 0; i <10 ; i++){
                p.hornear("Pan número: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i =0; i < 10;i++ ){
                p.consumir();
            }
        }).start();

    }
}
