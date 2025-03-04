package com.ds.threads;

public class RunThreadsUsingMethodReference {

    public static void main(String[] args) {
        RunThreadsUsingMethodReference o = new RunThreadsUsingMethodReference();

        Thread t1 = new Thread(o :: printNumbers);
        Thread t2 = new Thread(o :: printCharacters);

        t1.start();
        t2.start();
    }

    static Object lock = new Object();

    static boolean printNum = true;

    private void printNumbers() {

        synchronized (lock) {
            for(int i = 1; i <=5; i++) {
                while(!printNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(i);
                printNum = false;
                lock.notify();
            }
        }

    }

    private void printCharacters() {

        synchronized (lock) {
            for(char c = 'a'; c <= 'e'; c++) {
                while(printNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(c);
                printNum = true;
                lock.notify();
            }
        }
    }
}
