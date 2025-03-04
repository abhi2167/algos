package com.ds.leetcode.medium;

public class GasStation {

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};

        System.out.println(" can complete circle starting from = " + g.canCompleteCircuit(gas, cost));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int answer = 0;
        int totalGain = 0;
        int currentGain = 0;
        for(int i = 0; i < gas.length; i++) {
            currentGain += gas[i] - cost[i];
            totalGain += gas[i] - cost[i];
            if(currentGain < 0) {
                answer = i+1;
                currentGain = 0;
            }
        }
        return totalGain >= 0 ? answer : -1;
    }
}
