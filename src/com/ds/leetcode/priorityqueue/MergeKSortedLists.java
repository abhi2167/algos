package com.ds.leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists o = new MergeKSortedLists();
        List<List<Integer>> lists = List.of(List.of(1,3,5), List.of(2,4,6), List.of(7,10));
        System.out.println("sorted list = " + o.mergeKSortedLists(lists));
    }

    public List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<Integer> res = new ArrayList<>();
        int k = lists.size();
        PriorityQueue<ListItem> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for(int i = 0; i < k; i++){
            queue.offer(new ListItem(lists.get(i).get(0), i, 0));
        }
        while(!queue.isEmpty()) {
            ListItem el = queue.poll();
            res.add(el.val);
            int headIndex = el.currentIndex + 1;
            if(headIndex < lists.get(el.listIndex).size()) {
                queue.offer(new ListItem(lists.get(el.listIndex).get(headIndex), el.listIndex, headIndex));
            }
        }
        return res;
    }
    
    class ListItem {
        int val;
        int listIndex;
        int currentIndex;
        
        public ListItem(int val, int listIndex, int currentIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.currentIndex = currentIndex;
        }
    }
}
