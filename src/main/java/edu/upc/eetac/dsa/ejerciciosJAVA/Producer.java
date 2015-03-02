package edu.upc.eetac.dsa.ejerciciosJAVA;

public class Producer implements Runnable {
    private Buffer buffer = null;
    private String line = null;

    public Producer(Buffer buffer, String line) {
        this.buffer = buffer;
        this.line = line;
    }


    public void run() {
        char chars[] = line.toCharArray();
        for (char c : chars) {
            buffer.put(c);
            // Uncomment to log what is writing the thread
            // System.out.println(Thread.currentThread().getName() + " writes " + c);
        }
    }
}
