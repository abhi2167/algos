package com.ds.leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PqueueDemo {

    public static void main(String[] args) {
        PqueueDemo o = new PqueueDemo();
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));
        pq.offer(o.new Task(3, "p 3"));
        pq.offer(o.new Task(20, "p 20"));
        pq.offer(o.new Task(5, " p 5"));
        while(!pq.isEmpty()) {
            Task t = pq.poll();
            System.out.println(" Priority = " + t.priority + " description " + t.description);
        }
    }

    class Task {
        int priority;
        String description;

        public Task(int priority, String description) {
            this.priority = priority;
            this.description = description;
        }
    }
}
