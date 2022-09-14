package com.josekisystems.hilos.ejemplos;

import com.josekisystems.hilos.runnable.ViajeTarea;

public class InterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Roma")).start();
        new Thread(new ViajeTarea("Florencia")).start();
        new Thread(new ViajeTarea("Venecia")).start();
        new Thread(new ViajeTarea("Pisa")).start();
        new Thread(new ViajeTarea("Milán")).start();
        new Thread(new ViajeTarea("Nápoles")).start();
        new Thread(new ViajeTarea("Verona")).start();
        new Thread(new ViajeTarea("Sorreto")).start();
        new Thread(new ViajeTarea("Siena")).start();
        new Thread(new ViajeTarea("Bolonia")).start();
        new Thread(new ViajeTarea("Genova")).start();
        new Thread(new ViajeTarea("Turin")).start();
        new Thread(new ViajeTarea("La Maddalena")).start();
        new Thread(new ViajeTarea("Murano")).start();
        new Thread(new ViajeTarea("La Spezia")).start();
        new Thread(new ViajeTarea("Amalfi")).start();
        new Thread(new ViajeTarea("Lucca")).start();
        new Thread(new ViajeTarea("Catania")).start();
        new Thread(new ViajeTarea("San Gimignano")).start();

    }
}
