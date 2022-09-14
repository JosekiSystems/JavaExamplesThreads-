package com.josekisystems.hilos.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduleExecutorFixedRate = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el método main... ");

        //CountDownLatch  lock = new CountDownLatch(5);

        AtomicInteger contador = new AtomicInteger(5);

        Future<?> future = scheduleExecutorFixedRate.scheduleAtFixedRate(() ->{
            System.out.println("Hola Mundo con tarea programada fija..." + contador ); // + lock
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000,2000, TimeUnit.MILLISECONDS);

        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);

        while (contador.get() >= 0 ){
            if(contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
        }

        System.out.println("Alguna otra tarea en el método main...");
        scheduleExecutorFixedRate.shutdown();
    }
}
