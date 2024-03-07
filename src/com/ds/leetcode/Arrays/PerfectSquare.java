package com.ds.leetcode.Arrays;

import java.util.*;

public class PerfectSquare {

    public static void main(String[] args) {
        PerfectSquare p = new PerfectSquare();
        int n = 23;
       // System.out.println(" Least number of perfect squares numbers " + p.numSquares(n));
        System.out.println(" Least number of perfect squares numbers " + p.numSquares_bu(n));
        System.out.println(" Least number of perfect squares numbers " + p.numSquares_greedy_recur(n));
        System.out.println(" Least number of perfect squares numbers " + p.numSquares_bfs(n));
    }


    public int numSquares_bfs(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i*i);
        }
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            level++;
            int k = queue.size();
            for(int i = 0; i < k; i++) {
                int remainder = queue.poll();
                for(int square : squares) {
                    if(square == remainder) {
                        return level;
                    } else if(remainder < square) {
                        break;
                    } else {
                        queue.add(remainder - square);
                    }
                }
            }
        }
        return level;
    }

    public int numSquares_greedy_recur(int n) {
        Set<Integer> squares = new HashSet<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i*i);
        }
        int count = 1;
        for(; count <= n; count++) {
            if(is_divided(n, count, squares)) {
                return count;
            }
        }
        return count;
    }

    private boolean is_divided(int n, int count, Set<Integer> squares) {
        if(count == 1) {
            return squares.contains(n);
        }
        for(int square : squares) {
            if(is_divided(n - square, count-1, squares)) {
                return true;
            }
        }
        return false;
    }

    // 1, ,4 ,9, 16, 25 ...
    public int numSquares_bu(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i*i);
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int s = 0; s < squares.size(); s++) {
                if(i < squares.get(s)) {
                    break;
                }
                dp[i] = Math.min(dp[i],  dp[i-squares.get(s)]+1);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        for(int i = 1; i * i <= n; i++) {
            ps.add(i*i);
        }
        int dp[] = new int[n+1];
        //Arrays.fill(dp, -1);
        return numSquares(n, dp);
    }

    List<Integer> ps = new ArrayList<>();

    public int numSquares(int n, int[] dp) {
        if(n == 0) {
            return 0;
        } else if(n <= 3) {
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        int numOfSq = Integer.MAX_VALUE;
        for (int square : ps) {
            if (n < square) {
                break;
            }
            numOfSq = Math.min(numOfSq, 1 + numSquares(n - square, dp));
        }
        return dp[n] = numOfSq;
    }
}
