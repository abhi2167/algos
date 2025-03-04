package com.ds.leetcode.Arrays.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> val;
        if(!timeMap.containsKey(key)) {
            val = new TreeMap<>();
        } else {
            val = timeMap.get(key);
        }
        val.put(timestamp, value);
        timeMap.put(key, val);
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> floorEntry = timeMap.get(key).floorEntry(timestamp);
        if(floorEntry == null) {
            return "";
        }
        return floorEntry.getValue();
    }
}