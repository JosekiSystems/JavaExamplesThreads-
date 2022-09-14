package com.josekisystems.hilos.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        AtomicInteger contadorAtomic = new AtomicInteger(3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

                          // int contador = 3;

                           @Override
                           public void run() {

                               //if (contador > 0) {
                               int i = contadorAtomic.getAndDecrement();
                               if( i>0 ){
                                   toolkit.beep();
                                   System.out.println("Tarea "+ i + " periódica en: "
                                           + new Date() + " nombre del Thread: "
                                           + Thread.currentThread().getName());
                                   //contador--;
                               } else {
                                   System.out.println("Finaliza el tiempo");
                                   timer.cancel();
                               }
                           }
                       },0,10000);

        System.out.println("Agendamos una tarea en 0 segundos con un periódo de 10 segundos");
    }
}
