package com.ds.leetcode.Arrays.painthouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintHouse3 {

    public static void main(String[] args) {
        PaintHouse3 p = new PaintHouse3();
        int [] houses = {0,0,0,0,0};
        int costs [][] = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int target = 3;
        int m = 5;
        int n = 2;
        System.out.println(" Min cost to paint houses with target using top down = " + p.minCost(houses, costs, m, n, target));

    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        Integer[][][] dp = new Integer[m][target+1][n+1];
        int minCost = minCost_tp(cost, houses, target, 0, 0, 0, dp);
        return minCost == MAX_COST ? - 1 : minCost;
    }


    // Maximum cost possible plus 1
    final int MAX_COST = Integer.MAX_VALUE;

    private int minCost_tp(int[][] costs, int[] houses, int target, int currentHouse, int neighborCount, int prevColor, Integer[][][] dp) {

        if(currentHouse == houses.length) {
            return neighborCount == target ? 0 : MAX_COST;
        }
        if(neighborCount > target) {
            return MAX_COST;
        }
        System.out.println("currentHouse " + currentHouse + " neighbor count " + neighborCount + " prev color " + prevColor);
        if(dp[currentHouse][neighborCount][prevColor] != null) {
            return dp[currentHouse][neighborCount][prevColor];
        }
        int minCost = MAX_COST;

        if (houses[currentHouse] != 0) {
            int newNeighborhoodCount = neighborCount + (houses[currentHouse] != prevColor ? 1 : 0);
            minCost =
                    minCost_tp(costs, houses, target,currentHouse + 1, newNeighborhoodCount, houses[currentHouse], dp);
        } else {
            int totalColors = costs[0].length;

            // If the house is not painted, try every possible color and store the minimum cost
            for (int color = 1; color <= totalColors; color++) {
                int newNeighborhoodCount = neighborCount + (color != prevColor ? 1 : 0);
                int currCost = costs[currentHouse][color - 1]
                        + minCost_tp(costs,houses, target,currentHouse + 1, newNeighborhoodCount, color, dp);
                if(currCost >= 0 && currCost < minCost) {
                    minCost = currCost;
                }
            }
        }
        return dp[currentHouse][neighborCount][prevColor] = minCost;
    }
}
