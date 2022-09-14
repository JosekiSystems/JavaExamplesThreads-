package com.josekisystems.hilos.ejemplos.sync;

import com.josekisystems.hilos.ejemplos.sync.runnable.Consumidor;
import com.josekisystems.hilos.ejemplos.sync.runnable.Panadero;

public class ProductorConsumidor {
    public static void main(String[] args) {

        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }
}
