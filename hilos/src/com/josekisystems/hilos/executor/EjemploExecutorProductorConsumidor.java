package com.josekisystems.hilos.executor;

import com.josekisystems.hilos.ejemplos.sync.Panaderia;
import com.josekisystems.hilos.ejemplos.sync.runnable.Consumidor;
import com.josekisystems.hilos.ejemplos.sync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //Executors.newSingleThreadExecutor()
        //ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        System.out.println("Tamaño del Pool = " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en espera = " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> Futuro1 = executor.submit(productor);
        Future<?> Futuro2 = executor.submit(consumidor);


        System.out.println("Tamaño del Pool = " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en espera = " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main");



    }
}
