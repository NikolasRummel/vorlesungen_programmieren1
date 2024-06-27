package de.dhbw.nikolas.exercise.threads.buffer;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

class MyBuffer {
    private static final int BUFFER_MAX_SIZE = 3;
    private Stack<Integer> values;

    public MyBuffer() {
        this.values = new Stack<>();
    }

    public synchronized void put(int v) {
        if (isFull()) {
            try {
                System.out.println("Stack full! Waiting...");
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        if (!isFull()) {
            this.values.push(v);
        }
        this.notify();
        System.out.println("Put: " + v);
        this.simulateDelayAndPrint();
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
        System.out.println("Get:" + v);
        this.simulateDelayAndPrint();
        return v;
    }

    public void simulateDelayAndPrint() {
        Random random = new Random();
        int delay = 50 + random.nextInt(451);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {

        }
        printStack();
    }

    public void printStack() {
        System.out.println(this.values.size() + "/" + BUFFER_MAX_SIZE);
    }

    public boolean isFull() {
        return this.values.size() >= BUFFER_MAX_SIZE;
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }
}