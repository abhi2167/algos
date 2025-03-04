package com.ds.leetcode.Arrays.SlidingWindow;

public class MaxScoreFromBeginEndingCards {

    public static void main(String[] args) {
        MaxScoreFromBeginEndingCards m = new MaxScoreFromBeginEndingCards();
        int [] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Max score by picking cards from beginning or ending = " + m.maxScore(cardPoints, k));
        System.out.println("Max score by picking cards from beginning or ending = " + m.maxScore2(cardPoints, k));
        System.out.println("Max score by picking cards from beginning or ending = " + m.maxScore_dp(cardPoints, k));
        System.out.println("Max score by picking cards from beginning or ending = " + m.maxScore_prefixsum(cardPoints, k));
    }

    public int maxScore_prefixsum(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int[] prefixSumFromStart = new int[k+1];
        int[] prefixSumFromEnd = new int[k+1];
        for(int i=0; i < k; i++) {
            prefixSumFromStart[i+1] = prefixSumFromStart[i] + cardPoints[i];
        }
        for(int i=0; i < k; i++) {
            prefixSumFromEnd[i+1] = prefixSumFromEnd[i] + cardPoints[n-1-i];
        }
        for(int i = 0; i <= k; i++) {
            int currentSum = prefixSumFromStart[i] + prefixSumFromEnd[k-i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int maxScore_dp(int[] cardPoints, int k) {
        int [][]dp = new int[cardPoints.length][k];
        return maxScore_dp(cardPoints, 0, k, 0, dp);
    }

    public int maxScore_dp(int[] cardPoints, int left, int subarrayLength, int op, int[][] dp) {

        if(op == subarrayLength) {
            return 0;
        }

        if(dp[left][op] != 0) {
            return dp[left][op];
        }

        int right = cardPoints.length-1 - (op-left);
        //System.out.println("left = " + left + " right = " + right);

        return dp[left][op] = Math.max(cardPoints[left] + maxScore_dp(cardPoints, left+1, subarrayLength, op+1, dp), cardPoints[right] + maxScore_dp(cardPoints, left, subarrayLength, op+1, dp));
    }

    public int maxScore(int[] cardPoints, int k) {

        int totalScore = 0;
        for(int i = 0; i < cardPoints.length; i++) {
            totalScore += cardPoints[i];
        }

        if(cardPoints.length == k) {
            return totalScore;
        }

        int minSubarrayScore = totalScore;
        int currentSum = 0;
        int left = 0;
        for(int right = 0; right < cardPoints.length; right++) {
            currentSum += cardPoints[right];
            if(right - left + 1 == cardPoints.length - k) {
                minSubarrayScore = Math.min(minSubarrayScore, currentSum);
                currentSum -= cardPoints[left];
                left++;
            }
        }
        return totalScore - minSubarrayScore;
    }

    public int maxScore2(int[] cardPoints, int k) {

        int totalScore = 0;
        int totalLeftSubArrayScore = 0;
        for(int i = 0; i < cardPoints.length; i++) {
            totalScore += cardPoints[i];
            if(i < k) {
                totalLeftSubArrayScore += cardPoints[i];
            }
        }

        if(cardPoints.length == k) {
            return totalScore;
        }

        int currentSum = totalLeftSubArrayScore;
        int maxSum = currentSum;
        int left = k-1;
        int right = cardPoints.length-1;
        while(right >= cardPoints.length - k && left >=0) {
            currentSum += cardPoints[right] - cardPoints[left];
            maxSum = Math.max(maxSum, currentSum);
            right--;
            left--;

        }
        return maxSum;
    }
}
