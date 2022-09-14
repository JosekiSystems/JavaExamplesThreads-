package com.josekisystems.hilos.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

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

        Future<String> resutado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println("resutado.isDone(1) = " + resutado.isDone());
        //System.out.println("Continuamos...");

        while (!resutado.isDone()){
            System.out.println("Ejecutando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("Obtenemos el resultado de la tarea (resultado.get) =  " + resutado.get()); //resutado.get(5,TimeUnit.SECONDS)
        System.out.println("Finaliza la Tarea (resutado.isDone) = " + resutado.isDone());



    }
}
