package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        FriendsOfAppropriateAges o = new FriendsOfAppropriateAges();
        int [] ages = {20,20,30,100,110,120,120,120};
        System.out.print("Max number of friends requests = " + o.numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {
        int maxReq = 0;
        Arrays.sort(ages);
        for(int i = 0; i < ages.length; i++) {
            int age = ages[i];
            int lower = binSearch(ages, (int) (0.5*age + 7));
            int higher = binSearch(ages, age) - 1;
            maxReq += Math.max(higher - lower, 0);
        }
        return maxReq;
    }

    private int binSearch(int[] ages, int target) {
        int left = 0;
        int right = ages.length-1;
        int mid;
        while(left <= right) {
            mid = (left + right)/2;
            if(ages[mid] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
