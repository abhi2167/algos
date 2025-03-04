package com.ds.leetcode.Strings;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression o = new StringCompression();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.print("compressed string = " + o.compress(chars));
    }

    public int compress(char[] chars) {
        int left = 0;
        int count = 1;
        int right = 1;
        while(right <= chars.length) {
            if(right < chars.length && chars[right] == chars[right-1]) {
                count++;
            } else {
                chars[left] = chars[right-1];
                left++;
                if(count > 1) {
                    for(char c : String.valueOf(count).toCharArray()) {
                        chars[left] = c;
                        left++;
                    }
                }
                count = 1;
            }
            right++;
        }
        return left;
    }
}
