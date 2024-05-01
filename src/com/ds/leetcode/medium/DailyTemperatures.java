package com.ds.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(" DailyTemperatures result = " + Arrays.toString(d.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] warmTemp = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(stack.peekLast() != null && temperatures[stack.peekLast()] < temperatures[i]) {
                int previousDay = stack.pollLast();
                warmTemp[previousDay] = i - previousDay;
            }
            stack.offerLast(i);
        }
        return warmTemp;
    }
}
