package com.ds.leetcode.Arrays.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels o = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        System.out.print("Result of partioning the string " + o.partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> lastSeen = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastSeen.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int j = 0;
        int partitionAnchor = 0;
        for(int i = 0; i < s.length(); i++) {
            j = Math.max(j, lastSeen.get(s.charAt(i)));
            if(i == j) {
                result.add(j-partitionAnchor+1);
                partitionAnchor = i+1;
            }
        }
        return result;
    }
}
