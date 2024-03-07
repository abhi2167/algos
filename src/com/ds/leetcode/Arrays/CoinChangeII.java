package com.ds.leetcode.Arrays;

import java.util.*;

public class CoinChangeII {

    public static void main(String[] args) {

        CoinChangeII c = new CoinChangeII();
//        int [] coins = {2};
//        int amount = 3;
//        int [] coins = {2};
//        int amount = 1;
        int [] coins = {1,2};
        int amount = 2;

        System.out.println(" number of combinations  "  + c.change(amount, coins));
        System.out.println(" number of combinations bu "  + c.change_bu(amount, coins));
    }

    public int change_bu(int amount, int[] coins) {
        int rows = coins.length+1;
        int cols = amount+1;
        int [][] dp = new int[rows][cols];
        for(int i=0; i < rows; i++) {
            dp[i][0] = 1;
        }
        for(int i = rows-2; i>=0; i--) {
            for(int j = 1; j < cols; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-coins[i]];
                }
            }
        }
        System.out.println("===");
        for(int[] row : dp)
            System.out.println(Arrays.toString(row));
        return dp[0][amount];
    }


    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result =  change(amount, coins, dp, 0);
        System.out.println("--");
        for(int[] row : dp)
            System.out.println(Arrays.toString(row));
        System.out.println("--");
        return result;
    }

    public int change(int amount, int[] coins, int[][] dp, int currentIndex) {
        if(amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(currentIndex >= coins.length) {
            return 0;
        }
        if(dp[currentIndex][amount] != -1) {
            return dp[currentIndex][amount];
        }
        if(coins[currentIndex] > amount) {
            return dp[currentIndex][amount] = change(amount, coins, dp, currentIndex+1);
        }

        return dp[currentIndex][amount] = change(amount, coins, dp, currentIndex+1) + change(amount - coins[currentIndex], coins, dp, currentIndex);
    }


    // BFS methods below provides the number of permutations instead of combinations for result sum
    public int coinChange_bfs2(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(amount);
        Set<Integer> visited = new HashSet<>();
        //visited.add(amount);
        int count = 0;
        while(!queue.isEmpty()) {
            System.out.println(queue);
            Set<Integer> nextQueue = new HashSet<>();
            for(Integer remainder : queue) {
                if (remainder == 0) {
                    count++;
                }
                for (int i = 0; i < coins.length; i++) {
                    if (coins[i] <= remainder && !visited.contains(remainder - coins[i])) {
                        nextQueue.add(remainder - coins[i]);
                        //visited.add(remainder - coins[i]);
                    }
                }
            }
            queue = nextQueue;
        }
        return count;
    }

    public int coinChange_bfs(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount, 0});
        Set<Integer> visited = new HashSet<>();
        //visited.add(amount);
        int count = 0;
        while(!queue.isEmpty()) {
            System.out.println();
            queue.stream().mapToInt( i -> i[0]).forEach(i -> System.out.print(" " + i));
            System.out.println();
            int[] currentItem = queue.poll();
            if(currentItem[0] == 0) {
                count++;
            }
            for(int i=0; i < coins.length; i++) {
                if (coins[i] <= currentItem[0] && !visited.contains(currentItem[0] - coins[i])) {
                    queue.offer(new int[]{currentItem[0] - coins[i], currentItem[1]+1});
                    //visited.add(currentItem[0] - coins[i]);
                }
            }
        }
        return count;
    }
}
