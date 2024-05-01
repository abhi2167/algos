package com.ds.leetcode.Arrays.painthouse;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class PaintHouse2 {
    public static void main(String[] args) {
        PaintHouse2 p = new PaintHouse2();
        int[][] costs = {{1, 2, 3}, {1, 9, 9}, {2, 7, 3}};
        System.out.println("Min cost to paint houses top down = " + p.minCost_tp(costs));
        System.out.println("Min cost to paint houses bottom up = " + p.minCost_bu(costs));
        System.out.println("Min cost to paint houses bottom up optimized = " + p.minCost_bu_optimized(costs));
        System.out.println("Min cost to paint houses bfs = " + p.minCost_bfs(costs));
    }

    class State {
        int house;
        int color;
        int cost;

        public State() {

        }

        public State(int house, int color, int cost) {
            this.house = house;
            this.color = color;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return house == state.house && color == state.color && cost == state.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(house, color, cost);
        }

        @Override
        public String toString() {
            return "State{" +
                    "house=" + house +
                    ", color=" + color +
                    ", cost=" + cost +
                    '}' + "\n";
        }
    }

    // memorization does not help with BFS approach
    public int minCost_bfs(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int k = costs[0].length;
        Queue<State> queue = new LinkedList<>();
        for (int color = 0; color < k; color++) {
            queue.offer(new State(0, color, costs[0][color]));
        }
        HashSet<State> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int house = currentState.house;
            int color = currentState.color;
            int cost = currentState.cost;
            if (house == costs.length - 1) {
                minCost = Math.min(minCost, cost);
                continue;
            }
            for (int nextColor = 0; nextColor < k; nextColor++) {
                if (nextColor == color) {
                    continue;
                }
                State nextState = new State(house + 1, nextColor, cost + costs[house+1][nextColor]);
               if(!visited.contains(nextState)) {
                    queue.offer(nextState);
                    visited.add(nextState);
               }
            }
        }
        System.out.println(visited);
        return minCost;
    }

    public int minCost_bu_optimized(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int k = costs[0].length;
        int dp[][] = new int[costs.length][k];
        for (int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
            minCost = Math.min(minCost, dp[0][color]);
        }
        if (costs.length == 1) {
            return minCost;
        }
        minCost = Integer.MAX_VALUE;
        int prevHomeFirstMin = -1;
        int prevHomeSecondMin = -1;
        for (int house = 1; house < costs.length; house++) {
            prevHomeFirstMin = Integer.MAX_VALUE;
            prevHomeSecondMin = Integer.MAX_VALUE;
            for (int color = 0; color < k; color++) {

                if (prevHomeFirstMin == Integer.MAX_VALUE || costs[house - 1][color] < costs[house - 1][prevHomeFirstMin]) {
                    prevHomeSecondMin = prevHomeFirstMin;
                    prevHomeFirstMin = color;
                } else if (prevHomeSecondMin == Integer.MAX_VALUE || costs[house - 1][color] < costs[house - 1][prevHomeSecondMin]) {
                    prevHomeSecondMin = color;
                }
            }
            for (int color = 0; color < k; color++) {
                if (color == prevHomeFirstMin) {
                    dp[house][color] = costs[house][color] + dp[house - 1][prevHomeSecondMin];
                } else {
                    dp[house][color] = costs[house][color] + dp[house - 1][prevHomeFirstMin];
                }
                if (house == costs.length - 1) {
                    minCost = Math.min(minCost, dp[house][color]);
                }
            }
        }
        return minCost;
    }

    public int minCost_bu(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int k = costs[0].length;
        int dp[][] = new int[costs.length][k];
        for (int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
            minCost = Math.min(minCost, dp[0][color]);
        }
        if (costs.length == 1) {
            return minCost;
        }
        minCost = Integer.MAX_VALUE;
        for (int house = 1; house < costs.length; house++) {
            for (int color = 0; color < k; color++) {
                int minCostForPrevHouse = Integer.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    if (j != color) {
                        minCostForPrevHouse = Math.min(minCostForPrevHouse, dp[house - 1][j]);
                    }
                }
                dp[house][color] = costs[house][color] + minCostForPrevHouse;
                if (house == costs.length - 1) {
                    minCost = Math.min(minCost, dp[house][color]);
                }
            }
        }
        return minCost;
    }

    public int minCost_tp(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        int k = costs[0].length;
        int dp[][] = new int[costs.length][costs[0].length];
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, minCost_tp(costs, 0, i, dp));
        }
        return minCost;
    }

    private int minCost_tp(int[][] costs, int house, int color, int[][] dp) {
        if (house == costs.length - 1) {
            return costs[house][color];
        }
        if (dp[house][color] != 0) {
            return dp[house][color];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = 0; k < costs[0].length; k++) {
            if (k != color) {
                minCost = Math.min(minCost, minCost_tp(costs, house + 1, k, dp));
            }
        }
        return dp[house][color] = minCost + costs[house][color];
    }
}

/**
 * State{house=1, color=0, cost=3}
 * , State{house=1, color=0, cost=4}
 * , State{house=2, color=2, cost=6}
 * , State{house=2, color=2, cost=7}
 * , State{house=1, color=2, cost=10}
 * , State{house=1, color=1, cost=10}
 * , State{house=1, color=2, cost=11}
 * , State{house=2, color=1, cost=10}
 * , State{house=1, color=1, cost=12}
 * , State{house=2, color=1, cost=11}
 * , State{house=2, color=2, cost=13}
 * , State{house=2, color=0, cost=12}
 * , State{house=2, color=0, cost=13}
 * , State{house=2, color=2, cost=15}
 * , State{house=2, color=0, cost=14}
 * , State{house=2, color=1, cost=17}
 * , State{house=2, color=1, cost=18}
 */