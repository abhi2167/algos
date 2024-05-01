package com.ds.leetcode.Arrays.paintfence;

import java.util.*;

public class PaintFence {

    public static void main(String[] args) {
        PaintFence p = new PaintFence();
        int n = 3;
        int k = 2;
        System.out.println(Integer.parseInt("06"));
        System.out.println("Number of ways to paint fence tp " + p.numWays(n, k));
        System.out.println("Number of ways to paint fence bfs " + p.numWays_bfs(n, k));
        System.out.println("Number of ways to paint fence tp " + p.numWays_bu(n, k));
    }

    public int numWays_bu(int n, int k) {
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++) {
            dp[i] = (k-1) * (dp[i-2] + dp[i-1]);
        }
        return dp[n];
    }

    public int numWays(int n, int k) {
        if(n == 1) {
            return k;
        }
        if(n == 2) {
            return k * k;
        }
        return (k-1) * (numWays(n-2, k) +numWays(n-1, k));
    }

    public int numWays_bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0,0});
        int numOfWays = 0;
        Set<String> seen = new HashSet<>();
        seen.add("000");
        int[][][] visited = new int[n + 1][k + 1][3];
        visited[0][0][0] = 1;
        while(!queue.isEmpty()) {
            int[] currentItem = queue.poll();
            int post = currentItem[0];
            int color = currentItem[1];
            int count = currentItem[2];
            if(post == n) {
                numOfWays++;
                continue;
            }
            for(int nextColor = 1; nextColor <= k; nextColor++) {

                if(nextColor == color && count == 2) {
                    continue;
                }
                int nextCount = nextColor == color ? count + 1 : 1;
                if(visited[post + 1][nextColor][nextCount] == 0) {
                    queue.offer(new int[]{post+1, nextColor, nextCount});
                    visited[post + 1][nextColor][nextCount] = 1;
                }
                visited[post + 1][nextColor][nextCount] += visited[post][color][count];
            }
        }
        System.out.println(seen);
        return numOfWays;
    }
}
