package com.ds.leetcode.Strings;

import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String s = "abcdba";
        System.out.println(p.isPalindrome(s));
        System.out.println(p.fibonacci(6));
        p.fibonacci();
        // 0 1 1 2 3 5 8 13
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public int fibonacci(int n) {
        if( n == 0) return 0;
        if( n == 1 || n ==2 ) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public void fibonacci() {
        int n = 6;
        int [] arr = new int[n];
        arr[0] = 0; arr[1] = 1;
        for(int i=2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(Arrays.toString(arr));
    }


}
