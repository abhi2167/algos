package com.ds.leetcode.Arrays.binarysearch;

import java.util.TreeMap;

public class MyCalendar1 {

    TreeMap<Integer, Integer> calendar;
    public static void main(String[] args) {
        MyCalendar1 o = new MyCalendar1();
        o.book(10,20);
        o.book(30,40);
        o.book(40,50);
        o.book(15,25);
        o.book(20,30);
        System.out.println(o.calendar);
    }

    public MyCalendar1() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime);
        Integer next = calendar.ceilingKey(startTime);
        if((prev == null || calendar.get(prev) <= startTime) && (next == null || endTime <= next)) {
            calendar.put(startTime, endTime);
            return true;
        }
        return false;
    }

}
