package com.ds.leetcode.Strings;

public class StringMatching {

    public static void main(String[] args) {
        StringMatching s = new StringMatching();
        String hayStack = "mississippi";
        String needle = "issip";
        System.out.println(" String Matching = " + s.strStr1(hayStack, needle));
        System.out.println(" String Matching = " + s.strStr2(hayStack, needle));
        System.out.println(" String Matching = " + s.strStr3(hayStack, needle));
        System.out.println((int)Math.pow(10,9)+7);
    }

    // Rabin Karp Single Hash Algorithm
    public int strStr3(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if( n < m)
            return -1;
        int radix = 26;
        int mod = 1000000033;
        int hash_needle = hash_value(needle, m, radix, mod);
        int hash_haystack = 0;
        long max_weight = 1;

        for(int i=0; i < m; i++) {
            max_weight = (max_weight * radix) % mod;
        }

        for(int windowStart = 0; windowStart <= n-m; windowStart++) {

            if(windowStart == 0) {
                hash_haystack = hash_value(haystack, m, radix, mod);
            } else {
                hash_haystack = (int) (((hash_haystack * radix) % mod ) - (((haystack.charAt(windowStart-1) - 97) * max_weight) % mod)
                                                    + ((haystack.charAt(windowStart + (m-1)) - 'a') + mod) % mod);
            }

            if(hash_needle == hash_haystack) {
                for(int j = 0; j < m; j++) {
                    if(haystack.charAt(windowStart+j) != needle.charAt(j)) {
                        break;
                    }
                    if(j == m-1) {
                        return windowStart;
                    }
                }
            }
        }
        return -1;
    }

    public int hash_value(String s, int m, int radix, int mod) {
        long ans = 0;
        long factor = 1;
        for(int i = m-1; i >=0; i--) {
            ans += ((s.charAt(i) - 'a') * factor ) % mod;
            factor = (factor * radix) % mod;
        }
        return (int) ans;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int windowStart = 0; windowStart <= n-m; windowStart++) {
            for(int j = 0; j < m; j++) {
                if(haystack.charAt(windowStart+j) != needle.charAt(j)) {
                    break;
                }
                if(j == m-1) {
                    return windowStart;
                }
             }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0, j = 0;
        int index = -1;
        while(i < m && j < n) {
            if(needle.charAt(j) == haystack.charAt(i)) {
                index = index == -1 ? i : index;
                j++;
            } else {
                i = i - j;
                j = 0;
                index = -1;
            }
            i++;
        }
        return j == n ? index : -1;
    }
}
