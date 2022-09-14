package com.josekisystems.hilos.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduleExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService scheduleExecutor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el método main... ");

        scheduleExecutor.schedule(() ->{
            System.out.println("Hola Mundo con tarea programada 0...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola Mundo con tarea programada...");
        },2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el método main...");
        scheduleExecutor.shutdown();
    }
}
