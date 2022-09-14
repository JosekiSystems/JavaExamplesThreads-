package com.josekisystems.hilos.ejemplos.sync.runnable;

import com.josekisystems.hilos.ejemplos.sync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{

    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i = 0; i <10 ; i++){
            panaderia.hornear("Pan número: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
