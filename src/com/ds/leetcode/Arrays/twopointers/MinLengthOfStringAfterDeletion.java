package com.ds.leetcode.Arrays.twopointers;

public class MinLengthOfStringAfterDeletion {

    public static void main(String[] args) {
        MinLengthOfStringAfterDeletion o = new MinLengthOfStringAfterDeletion();
        String s = "abbba";
        System.out.println("min length of string after deletion = " + o.minimumLength(s));
    }

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        System.out.println(s.length());
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return right - left + 1;
            }
            if(right - left + 1 == 2) {
                return 0;
            }
            char ch = s.charAt(left);
            while(left <= right && s.charAt(left) == ch) {
                left++;
            }
            while(right > left && s.charAt(right) == ch) {
                right--;
            }
        }
        System.out.println(" left " + left + " right " + right);
        return right-left+1;
    }
}
