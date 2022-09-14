package com.josekisystems.hilos.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //Executors.newSingleThreadExecutor()
        //ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        System.out.println("Tamaño del Pool = " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en espera = " + executor.getQueue().size());
        //Runnable
              Callable<String>  tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println(" Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la Tarea...");
            return "Algún resultado importante de la tarea";
        };

              Callable<Integer> tarea2 = () ->{
                  System.out.println("Iniciamos tarea 3...");
                  TimeUnit.SECONDS.sleep(3);
                  return 9;
              };

        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del Pool = " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en espera = " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println("resutado.isDone(1) = " + resutado.isDone());
        //System.out.println("Continuamos...");

        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
           // System.out.println("Ejecutando tarea...");
            System.out.println("String.format(...)" + String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()?  "finalizó ": " en proceso ",
                    resultado2.isDone()? "finalizó ": " en proceso ",
                    resultado3.isDone()? "finalizó ": " en proceso "));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("Obtenemos el resultado de la tarea1 (resultado.get) =  " + resultado.get()); //resutado.get(5,TimeUnit.SECONDS)
        System.out.println("Finaliza la Tarea (resutado.isDone) = " + resultado.isDone());

        System.out.println("Obtenemos el resultado de la tarea2 (resultado.get) =  " + resultado2.get());
        System.out.println("Finaliza la Tarea2 (resutado2.isDone) = " + resultado2.isDone());

        System.out.println("Obtenemos el resultado de la tarea3 (resultado.get) =  " + resultado3.get());
        System.out.println("Finaliza la Tarea3 (resutado3.isDone) = " + resultado3.isDone());





    }
}
