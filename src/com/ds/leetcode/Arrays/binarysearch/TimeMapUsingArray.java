package com.ds.leetcode.Arrays.binarysearch;

import java.util.*;

public class TimeMapUsingArray {

    Map<String, List<Pair>> timeMap;
    public TimeMapUsingArray() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        List<Pair> values = timeMap.get(key);
        if(values.get(0).timeStamp > timestamp) {
            return "";
        }
        int left = 0;
        int right = values.size()-1;
        int pos = -1;
        int mid;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(values.get(mid).timeStamp <= timestamp) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return values.get(pos).value;
    }
}

class Pair {
    Integer timeStamp;
    String value;

    Pair(Integer timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

