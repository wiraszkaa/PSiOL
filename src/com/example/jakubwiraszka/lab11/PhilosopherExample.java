package com.example.jakubwiraszka.lab11;


public class PhilosopherExample implements Runnable {
    // The forks on either side of this Philosopher
    private Object leftFork;
    private Object rightFork;

    public PhilosopherExample(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        System.out.println(add(10, 16));
    }
    public int add(Integer a, Integer b ) {
        return a + b;
    }

    @Override
    public void run() {
        try {
            while (true) {

                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(
                            System.nanoTime()
                                    + ": Picked up left fork");
                    synchronized (rightFork) {
                        // eating
                        doAction(
                                System.nanoTime()
                                        + ": Picked up right fork - eating");

                        doAction(
                                System.nanoTime()
                                        + ": Put down right fork");
                    }

                    // Back to thinking
                    doAction(
                            System.nanoTime()
                                    + ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 5)));
    }
}
