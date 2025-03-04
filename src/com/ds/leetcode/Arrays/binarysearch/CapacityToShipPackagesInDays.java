package com.ds.leetcode.Arrays.binarysearch;

public class CapacityToShipPackagesInDays {

    public static void main(String[] args) {
        CapacityToShipPackagesInDays o = new CapacityToShipPackagesInDays();

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println("Minimum ship capacity to transfer packages in x days is = " + o.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        int totalWeight = 0;
        for(int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            totalWeight += weights[i];
        }
        right = totalWeight;
        int ans = 0;
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(countDays(mid, weights) <= days) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int countDays(int capacity, int[] weights) {
        int dayCount = 1;
        int totalWeight = 0;
        for(int i = 0; i < weights.length; i++) {
            if(totalWeight + weights[i] <= capacity) {
                totalWeight += weights[i];
            } else {
                totalWeight = weights[i];
                dayCount++;
            }
        }
        return dayCount;
    }
}
