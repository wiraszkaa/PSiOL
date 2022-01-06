package com.example.jakubwiraszka.lab11.examples.synchronization;

public abstract class AbstractThread extends Thread {

    public AbstractThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void doSomething() throws InterruptedException;
}
