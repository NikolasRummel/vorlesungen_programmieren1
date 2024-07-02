package de.dhbw.nikolas.exercise.threads.buffer;

import java.util.Random;
import java.util.Stack;

class MyBuffer {
    private static final int BUFFER_MAX_SIZE = 3;

    private final Stack<Integer> values;

    public MyBuffer() {
        this.values = new Stack<>();
    }

    public synchronized void put(int v) {
        if (this.isFull()) {
            try {
                System.out.println("Stack full! Waiting...");
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        if (!this.isFull()) {
            this.values.push(v);
        }
        this.notify();
        System.out.println("PUT:" + v + this.getFillLevel());
        this.simulateDelay(500);
    }

    public synchronized int get() {
        int v;
        if (isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        v = this.values.pop();
        this.notify();
        System.out.println("GET:" + v + this.getFillLevel());
        this.simulateDelay(200);
        return v;
    }

    private void simulateDelay(int max) {
        Random random = new Random();
        int delay = 50 + random.nextInt(max);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getFillLevel() {
       return " " + this.values.size() + "/" + BUFFER_MAX_SIZE;
    }

    private boolean isFull() {
        return this.values.size() >= BUFFER_MAX_SIZE;
    }

    private boolean isEmpty() {
        return this.values.isEmpty();
    }
}