package com.ds.threads;

public class TestThread {

    static final Object lock = new Object();
    static boolean numTurn = true;
    static class NumsRunnner implements Runnable {
        @Override
        public void run() {
            synchronized(lock) {
                for(int i = 1; i <= 4; i++) {
                    while(!numTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(i);
                    numTurn = false;
                    lock.notify();
                }
            }
        }
    }

    static class LettersRunnner implements Runnable {


        @Override
        public void run() {
            synchronized(lock) {
                for(char c = 'a'; c <= 'd'; c++) {
                    while(numTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(c);
                    numTurn = true;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new NumsRunnner());
        Thread t2 = new Thread(new LettersRunnner());
        t1.start();
        t2.start();
    }
}
