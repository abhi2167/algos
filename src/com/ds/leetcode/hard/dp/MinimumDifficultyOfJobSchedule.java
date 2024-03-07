package com.ds.leetcode.hard.dp;

import java.util.Arrays;

public class MinimumDifficultyOfJobSchedule {

    public static void main(String[] args) {
        MinimumDifficultyOfJobSchedule m = new MinimumDifficultyOfJobSchedule();
        int [] jobDifficulty = {7,1,7,1,5,1};
        int days = 4;
        System.out.println("Minimum difficulty of job schedule " + m.minDifficulty(jobDifficulty, days));
        System.out.println("Minimum difficulty of job schedule " + m.minDifficulty_bu(jobDifficulty, days));
    }

    public int minDifficulty_bu(int[] jobDifficulty, int days) {
        if(jobDifficulty.length < days) {
            return -1;
        }
        int[][] dp = new int[jobDifficulty.length+1][days + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int maxInDay = Integer.MIN_VALUE;
        for(int i = jobDifficulty.length-1; i >= days-1; i--) {
            maxInDay = Math.max(maxInDay, jobDifficulty[i]);
            dp[i][1] = maxInDay;
        }


        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for(int j = 2; j <= days; j++) {
            int dayMax = Integer.MIN_VALUE;
            for(int i = jobDifficulty.length-1; i >=0; i--) {
                //dayMax = Math.max(dayMax, jobDifficulty[i]);
                if(dp[i+1][j-1] >= 0) {
                    dp[i][j] = jobDifficulty[i] + dp[i+1][j-1];
                }
            }
        }

        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[0][days];
    }

    public int minDifficulty(int[] jobDifficulty, int days) {
        if(jobDifficulty.length < days) {
            return -1;
        }
        int[][] dp = new int[jobDifficulty.length][days + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int min =  minDifficulty(jobDifficulty, days, 0, dp);
        System.out.println("\n");
        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
        return min;
    }

    private int minDifficulty(int[] jobDifficulty, int remainderDays, int currentJob, int[][] dp) {

        System.out.println("\n======\n");
        for(int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        if(dp[currentJob][remainderDays] != -1) {
            return dp[currentJob][remainderDays];
        }

        if(remainderDays == 1) {
            int res = 0;
            for(int i = currentJob; i < jobDifficulty.length; i++) {
                res = Math.max(res, jobDifficulty[i]);
            }
            return dp[currentJob][remainderDays] = res;
        }
        int minDifficulty = Integer.MAX_VALUE;
        int dayMax = Integer.MIN_VALUE;
        for(int i = currentJob; i < jobDifficulty.length - remainderDays + 1; i++) {
           dayMax = Math.max(dayMax, jobDifficulty[i]);
           int result = dayMax + minDifficulty(jobDifficulty, remainderDays-1, i+1, dp);
            minDifficulty = Math.min(minDifficulty, result);
        }
        dp[currentJob][remainderDays] = minDifficulty;
        return minDifficulty;
    }
}
