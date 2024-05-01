package com.ds.leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

public class BuildingWithOceanView {

    public static void main(String[] args) {
        BuildingWithOceanView  b = new BuildingWithOceanView();
        int[] heights = {4,2,3,1};
        System.out.println("Buildings with Ocean View = " + Arrays.toString(b.findBuildings(heights)));
        System.out.println("Buildings with Ocean View = " + Arrays.toString(b.findBuildings_linear(heights)));
    }

    public int[] findBuildings(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; i++) {
            while(stack.peekLast() != null && heights[stack.peekLast()] <= heights[i]) {
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public int[] findBuildings_linear(int[] heights) {

        List<Integer> res = new ArrayList<>();
        int n = heights.length;
        for(int i = 0; i < n; i++) {
            while(!res.isEmpty() && res.get(res.size()-1)  <= heights[i]) {
                res.remove(res.size()-1);
            }
            res.add(i);
        }
        return res.stream().mapToInt(i-> i).toArray();
    }
}
