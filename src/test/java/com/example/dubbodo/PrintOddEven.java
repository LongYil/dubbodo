package com.example.dubbodo;

class PrintOddEven {
    private final Object lock = new Object();
    private boolean oddTurn = true;

    public void printOdd() {
        synchronized (lock) {
            for (int i = 1; i <= 100; i += 2) {
                while (!oddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd: " + i);
                oddTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            for (int i = 2; i <= 100; i += 2) {
                while (oddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even: " + i);
                oddTurn = true;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven printOddEven = new PrintOddEven();
        Thread t1 = new Thread(printOddEven::printOdd);
        Thread t2 = new Thread(printOddEven::printEven);

        t1.start();
        t2.start();
    }
}
