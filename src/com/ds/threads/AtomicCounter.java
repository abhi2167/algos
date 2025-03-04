package com.ds.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger requestCount = new AtomicInteger(0);

    public void processRequest() {
        int currentCount = requestCount.incrementAndGet(); // Thread-safe increment
        System.out.println("Processed request #" + currentCount + " by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

        // Simulate multiple threads handling requests
        for (int i = 1; i <= 5; i++) {
            new Thread(counter::processRequest, "Thread"+i).start();
        }
    }
}

