package com.ds.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class RunThreadsUsingAtomicInteger {

    private final AtomicInteger turn = new AtomicInteger(1);
    public static void main(String[] args) {
        RunThreadsUsingAtomicInteger printer = new RunThreadsUsingAtomicInteger();

        Thread thread1 = new Thread(printer::printNumbers);
        Thread thread2 = new Thread(printer::printLetters);

        thread1.start();
        thread2.start();
    }


    public void printNumbers() {
        for (int i = 1; i <= 3; i++) {
            while (turn.get() != 1) {
                // Busy-wait
            }
            System.out.print(i);
            turn.set(2); // Set turn to letters
        }
    }

    public void printLetters() {
        for (char c = 'a'; c <= 'c'; c++) {
            while (turn.get() != 2) {
                // Busy-wait
            }
            System.out.print(c);
            turn.set(1); // Set turn to numbers
        }
    }
}
