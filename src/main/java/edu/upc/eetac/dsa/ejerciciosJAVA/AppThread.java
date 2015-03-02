package edu.upc.eetac.dsa.ejerciciosJAVA;

public class AppThread {
    public static void main(String[] args) throws InterruptedException {
        EjemploThread threadClass = new EjemploThread("thread class");
        Thread thread = new Thread(new ThreadRunnable(),"runnable class");
        threadClass.start();
        thread.start();
        threadClass.join();
        thread.join();
        System.out.println("Se acabó.");
    }
}
