package com.example.dubbodo;

public class PrintNumbers {
    private static final int MAX = 99;
    private int number = 1;
    private int threadIdToRun = 1; // ID of the thread that should run (1, 2, or 3)
    private final Object lock = new Object();

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();

        Thread t1 = new Thread(new Task(printNumbers, 1));
        Thread t2 = new Thread(new Task(printNumbers, 2));
        Thread t3 = new Thread(new Task(printNumbers, 3));

        t1.start();
        t2.start();
        t3.start();
    }

    public void print(int threadId) {
        synchronized (lock) {
            while (number <= MAX) {
                while (threadId != threadIdToRun) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= MAX) {
                    System.out.println("Thread " + threadId + ": " + number++);
                }
                threadIdToRun = threadIdToRun % 3 + 1; // Update threadIdToRun to the next thread's ID
                lock.notifyAll();
            }
        }
    }
}

class Task implements Runnable {
    private final PrintNumbers printNumbers;
    private final int threadId;

    public Task(PrintNumbers printNumbers, int threadId) {
        this.printNumbers = printNumbers;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        printNumbers.print(threadId);
    }
}
