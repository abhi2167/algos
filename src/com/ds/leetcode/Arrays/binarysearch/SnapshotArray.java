package com.ds.leetcode.Arrays.binarysearch;

import java.util.TreeMap;

public class SnapshotArray {

    TreeMap<Integer, Integer> snapshots[];
    int snapId;
    public static void main(String[] args) {
        int length = 5;
        SnapshotArray o = new SnapshotArray(length);
        o.set(0,15);
        o.set(2,30);
        o.snap();
        o.snap();
        o.set(1,20);
        o.set(2,40);
        o.snap();
        o.set(4, 50);
        o.set(1,25);
        o.snap();
        System.out.println("index 0 snapId 0 " + o.get(0, 0));
        System.out.println("index 1 snapId 0 " + o.get(1, 0));
        System.out.println("index 2 snapId 0 " + o.get(2, 0));
        System.out.println("index 0 snapId 1 " + o.get(0, 1));
        System.out.println("index 4 snapId 0 " + o.get(4, 1));
        System.out.println("index 2 snapId 3 " + o.get(2, 2));
        System.out.println("index 2 snapId 3 " + o.get(2, 2));
        System.out.println("index 2 snapId 3 " + o.get(2, 2));
        System.out.println("index 2 snapId 3 " + o.get(2, 4));
    }

    public SnapshotArray(int length) {
        snapshots = new TreeMap[length];
        for(int i = 0; i < length; i++) {
            snapshots[i] = new TreeMap<>();
            snapshots[i].put(0,0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        snapshots[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {

        return snapshots[index].floorEntry(snap_id).getValue();
    }
}
