package com.ds.leetcode.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString o = new ReorganizeString();
        String s = "aabcddd"; //dadcdba
        System.out.println("Reorganized string with no adjacent duplicates = " + o.reorganizeString(s));
    }

    public String reorganizeString(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        int n = s.length();
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i),0) + 1);
        }
        System.out.println(charCount);
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            queue.offer(entry);
        }
        if(queue.peek().getValue() > n + 1) {
            return "";
        }
        int pointer = 0;
        char[] res = new char[n];
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                res[pointer] = entry.getKey();
                pointer += 2;
                if(pointer >= n) {
                    pointer = 1;
                }
            }
        }
        return new String(res);
    }
}
