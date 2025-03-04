package com.ds.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        BoatsToSavePeople s = new BoatsToSavePeople();
        int[] people = {3,5,3,4};
        int limit = 5;
        System.out.println("Min number of boats to save people with max 2 at a time = " + s.numRescueBoats(people, limit));
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0;
        int j = people.length-1;
        while( i <= j) {
            ans++;
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return ans;
    }
}
