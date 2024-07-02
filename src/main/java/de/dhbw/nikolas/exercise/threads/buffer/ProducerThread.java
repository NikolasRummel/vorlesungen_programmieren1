package de.dhbw.nikolas.exercise.threads.buffer;

public class ProducerThread extends Thread {
    MyBuffer buf;

    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }

    public void run() {
        this.buf.put(5);
        this.buf.put(6);
        this.buf.put(2);
        this.buf.put(3);
        this.buf.put(4);
        this.buf.put(1);
    }

}
