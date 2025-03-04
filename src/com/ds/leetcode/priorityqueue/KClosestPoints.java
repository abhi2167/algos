package com.ds.leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {

    public static void main(String[] args) {
        List<List<Integer>> points = List.of(List.of(1,1), List.of(2,2), List.of(3,3));
        System.out.println("points = " + points);

    }

    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Comparator<List<Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                return distanceToOrigin(p1) - distanceToOrigin(p2);
            }

            private int distanceToOrigin(List<Integer> p1) {
                return (p1.get(0) * p1.get(0)) + (p1.get(1)*p1.get(1));
            }
        };

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(points.size(), comparator);
        for(int i = 0; i < points.size(); i++) {
            queue.offer(points.get(i));
        }
        for(int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }
}

class PointsComparator implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> p1, List<Integer> p2) {
        return distanceToOrigin(p1) - distanceToOrigin(p2);
    }

    private int distanceToOrigin(List<Integer> p1) {
        return (p1.get(0) * p1.get(0)) + (p1.get(1)*p1.get(1));
    }
}
