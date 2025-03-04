package com.ds.leetcode.priorityqueue;

import java.util.*;

public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber o = new UglyNumber();
        int n = 11;
        System.out.println("nth ugly number is " + o.nthUglyNumber(n));
        System.out.println("nth ugly number btf is " + o.nthUglyNumber_btf(n));
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        int currentNum = 1;
        List<Integer> primeFactors = List.of(2, 3, 5);
        Set<Integer> usedNums = new HashSet<>();
        usedNums.add(1);
        for(int i = 0; i < n-1; i++) {
            currentNum = queue.poll();
            for(int prime : primeFactors) {
                if(!usedNums.contains(currentNum * prime)) {
                    queue.offer(currentNum * prime);
                    usedNums.add(currentNum * prime);
                }
            }
        }
        return queue.poll();
    }

    public int nthUglyNumber_btf(int n) {
        int maxInt = 1690;
        List<Integer> uglyNumbers = new ArrayList<>();
        for(int i = 1; i <= maxInt; i *= 2) {
            for(int j = i; j <= maxInt; j *= 3) {
                for(int k = j; k <= maxInt; k *= 5) {
                    uglyNumbers.add(k);
                }
            }
        }
        Collections.sort(uglyNumbers);
        return uglyNumbers.get(n-1);
    }
}
