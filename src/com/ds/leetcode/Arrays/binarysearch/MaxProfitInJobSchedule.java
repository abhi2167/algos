package com.ds.leetcode.Arrays.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxProfitInJobSchedule {

    public static void main(String[] args) {
        MaxProfitInJobSchedule o = new MaxProfitInJobSchedule();
        int[] startTime = {24,24,7,2,1,13,6,14,18,24};
        int[] endTime = {27,27,20,7,14,22,20,24,19,27};
        int[] profit = {6,1,4,2,3,6,5,6,9,8};
        System.out.println("MaxProfitInJobSchedule dp = " + o.jobScheduling(startTime, endTime, profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        jobs.sort(Comparator.comparingInt(job -> job.startTime));
        Arrays.sort(startTime);
        int dp[] = new int[jobs.size()];
        Arrays.fill(dp, -1);
        return jobScheduling(jobs, startTime, 0, dp);
    }

    private int jobScheduling(List<Job> jobs, int[] startTime, int currentJob, int[] dp) {

        if(currentJob >= jobs.size()) {
            return 0;
        }
        if(dp[currentJob] != -1) {
            return dp[currentJob];
        }
        int nextJobIndex = findNextJob( startTime, jobs.get(currentJob).endTime);
        return dp[currentJob] = Math.max(jobs.get(currentJob).profit + jobScheduling(jobs, startTime, nextJobIndex, dp),
                jobScheduling(jobs, startTime, currentJob+1, dp));
    }

    private int findNextJob(int[] startTime, int endTime) {
        int left = 0;
        int right = startTime.length-1;
        int mid;
        int ans = startTime.length;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(startTime[mid] >= endTime) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}

class Job {
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
