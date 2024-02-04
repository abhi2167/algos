package com.ds.leetcode.Strings;

import java.util.Arrays;

public class RemoveKDuplicates {

    public static void main(String[] args) {
        RemoveKDuplicates o = new RemoveKDuplicates();
//        String s = "deeedbbcccbdaa";
//        int k = 3;
//
        String s = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k=4;
        System.out.println(o.removeDuplicates(s, k));
        System.out.println(o.removeDuplicates_memorize(s, k));
    }

    public String removeDuplicates_memorize(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[sb.length()];
        for(int i=0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            System.out.println(Arrays.toString(count));
            if(i == 0 || ch != sb.charAt(i-1)) {
                count[i] = 1;
            } else  {
                count[i] = count[i-1] + 1;
                if(count[i] == k ) {
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
            }
        }

        return sb.toString();
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count = 1;
        for(int i=0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                count = 1;
            } else {
                count++;
                if(count == k) {
                    sb.delete(i-k+1, i+1);
                    i=0;
                    count = 1;
                }
            }
        }
        return sb.toString();
    }
}
