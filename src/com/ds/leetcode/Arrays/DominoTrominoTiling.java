package com.ds.leetcode.Arrays;

import java.util.HashMap;

public class DominoTrominoTiling {

    public static void main(String[] args) {
        DominoTrominoTiling d = new DominoTrominoTiling();
        System.out.println("Number of ways to to tile using domino and tromino top down = " + d.numTilings(3));
        System.out.println("Number of ways to to tile using domino and tromino bu = " + d.numTilings_bu(3));
    }

    public int numTilings_bu(int n) {
        long [] f = new long[n+1];
        long[] p = new long[n+1];
        f[1] = 1l;
        f[2] = 2l;
        p[2] = 1l;
        for(int k = 3; k <= n; k++) {
            f[k] = (f[k-1] + f[k-2] + (2 * p[k-1])) % mod;
            p[k] = (f[k-2] + p[k-1]) % mod;
        }
        return (int) f[n];
    }

    int mod = (int) (Math.pow(10,9) + 7);
    HashMap<Integer, Long> f_cache= new HashMap<>();
    HashMap<Integer, Long> pCache= new HashMap<>();
    public int numTilings(int n) {
        return (int) (f(n));
    }

    public long f(int n) {
        if(f_cache.containsKey(n)) {
            return f_cache.get(n);
        }
        if(n == 1) {
            return 1l;
        }
        if(n == 2) {
            return 2l;
        }
        Long val =  (f(n-1) + f(n-2) + (2 * p(n-1))) % mod;
        f_cache.put(n, val);
        return val;
    }

    public long p(int n) {
        if(pCache.containsKey(n)) {
            return pCache.get(n);
        }
        if(n == 2) {
            return 1l;
        }
        Long val = (f(n-2) + p(n-1)) % mod;
        pCache.put(n, val);
        return val;
    }
}
