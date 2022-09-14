package com.josekisystems.hilos.ejemplos;

import com.josekisystems.hilos.runnable.ImprimirFrases;

public class SincronizacionThread {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases(" A los Cuates "," Mis Aguacates" )).start();
        new Thread(new ImprimirFrases(" No por mucho madrugar ", " Amanece más temprano")).start();
        Thread.sleep(100);
        Thread h3 =new Thread (new ImprimirFrases(" Gracias Totales ", " Amigos"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());
    }

    public synchronized static  void imprimirFrases (String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(frase2);

    }
}
