package com.ds.leetcode.Arrays;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {

        CoinChange c = new CoinChange();
//        int [] coins = {2};
//        int amount = 3;
//        int [] coins = {2};
//        int amount = 1;
//        int [] coins = {186,419,83,408};
//        int amount = 6249;
        int [] coins = {1,2,5};
        int amount = 5;
//        int [] coins = {3, 186,419,83,408};
//        int amount = 6249;

        //System.out.println(" Result minimum coins "  + c.coinChange(coins, amount));
        System.out.println(" Result minimum coins "  + c.coinChange_bu(coins, amount));
        System.out.println(" Result minimum coins "  + c.coinChange_bfs(coins, amount));
        System.out.println(" Result minimum coins "  + c.coinChange_bfs2(coins, amount));
        System.out.println(" Loop counter 1" + c.loopCounter1);
        System.out.println(" Loop counter 2" + c.loopCounter2);
    }

    int loopCounter1 = 0;
    int loopCounter2 = 0;


    public int coinChange_bfs2(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(amount);
        Set<Integer> visited = new HashSet<>();
        visited.add(amount);
        int count = 0;
        while(!queue.isEmpty()) {
           Set<Integer> nextQueue = new HashSet<>();
           System.out.println(queue);
           for(Integer remainder : queue) {
               for (int i = 0; i < coins.length; i++) {
                   loopCounter2++;
                   if (remainder == 0) {
                       return count;
                   } else if (coins[i] <= remainder && !visited.contains(remainder - coins[i])) {
                       nextQueue.add(remainder - coins[i]);
                       visited.add(remainder - coins[i]);
                   }
               }
           }
           queue = nextQueue;
           count++;
        }
        System.out.println(" Loop counter " + loopCounter2);
        return -1;
    }

    public int coinChange_bfs(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(amount);
        while(!queue.isEmpty()) {
            System.out.println();
            queue.stream().mapToInt( i -> i[0]).forEach(i -> System.out.print(" " + i));
            System.out.println();
            int[] currentItem = queue.poll();
            if(currentItem[0] == 0) {
                return currentItem[1];
            }
            for(int i=0; i < coins.length; i++) {
                loopCounter1++;
                if (coins[i] <= currentItem[0] && !visited.contains(currentItem[0] - coins[i])) {
                    queue.offer(new int[]{currentItem[0] - coins[i], currentItem[1]+1});
                    visited.add(currentItem[0] - coins[i]);
                }
            }
        }

        return -1;
    }
    public int coinChange_bu(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    int ans = dp[i-coins[j]];
                    if(ans >= 0 && ans < dp[i]) {
                        dp[i] = 1 + ans;
                    }
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int ans =  coinChange(coins, amount, dp);
        return ans < 0 || ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int coinChange(int[] coins, int amount, int[] dp) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        int numOfCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int ans = coinChange(coins, amount - coins[i], dp);
            if (ans >= 0 && ans < numOfCoins) {
                numOfCoins = 1 + ans;
            }
        }
        dp[amount] = numOfCoins == Integer.MAX_VALUE ? -1 : numOfCoins;
        return dp[amount];
    }
}
