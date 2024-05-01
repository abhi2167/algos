package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class NumberOfDiceWithTargetsum {
    public static void main(String[] args) {
        NumberOfDiceWithTargetsum o = new NumberOfDiceWithTargetsum();
        //int n = 30, k = 30, target = 500;
        int n = 2, k = 6, target = 10;
        System.out.println("num of ways to get target = " + o.numRollsToTarget(n, k, target));
        System.out.println("num of ways to get target bottom up = " + o.numRollsToTarget_bu(n, k, target));
    }

    public int numRollsToTarget_bu(int n, int k, int target) {
        int[][]dp = new int[n+1][target+1];
        dp[0][0] = 1;
//        dp[1][1] = 1;
//        dp[1][2] = 1;
//        dp[1][3] = 1;
//        dp[1][4] = 1;
//        dp[1][5] = 1;
//        dp[1][6] = 1;
        for(int dice = 1; dice <= n; dice++) {
            for(int currentTarget = 1; currentTarget <= target; currentTarget++) {
                int totalWays = 0;
                for(int face=1; face <= target; face++) {
                    if(target - face >= 0) {
                        totalWays = (totalWays + dp[dice-1][target-face]) % mod;
                    }
                }
                dp[dice][target] = totalWays;
            }
        }
        for(int[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[n][target];
    }



    public int numRollsToTarget(int n, int k, int target) {
        Integer[][]dp = new Integer[n+1][target+1];
        int res = numRollsToTarget(n, k, target, dp);

        for(Integer[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
        return res;
    }


    int mod = (int) (Math.pow(10,9) + 7);
    public int numRollsToTarget(int n, int k, int target, Integer[][] dp) {
        if(n == 0 ) {
            if(target >= 0) {
                return dp[n][target] = target == 0 ?  1 :  0;
            } else {
                return target == 0 ?  1 :  0;
            }

        }
        if(target < 0) {
            return 0;
        }
        if(dp[n][target] != null) {
            return dp[n][target];
        }
        int totalWays = 0;
        for(int i=1; i <= k; i++) {
                totalWays =  (totalWays + numRollsToTarget(n-1, k, target-i, dp )) % mod;
        }
        return dp[n][target] = (totalWays);
    }
}
