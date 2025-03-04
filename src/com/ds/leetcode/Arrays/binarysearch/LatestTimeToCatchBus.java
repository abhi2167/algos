package com.ds.leetcode.Arrays.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatestTimeToCatchBus {

    public static void main(String[] args) {
        LatestTimeToCatchBus o = new LatestTimeToCatchBus();
        int[] buses = {3};
        int[] passengers = {4};
        int capacity = 1;
        System.out.println("Latest time to catch bus = " + o.latestTimeCatchTheBus(buses, passengers, capacity));
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int latestArrival = 0;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int m = buses.length;
        int n = passengers.length;
        Set<Integer> boardedPassengers = new HashSet<>();
        int currentPassenger = 0;
        int lastPassengerTime = 0;
        for(int i = 0; i < m; i++) {
            int currentCapacity = 0;
            while(currentCapacity < capacity && currentPassenger < n && passengers[currentPassenger] <= buses[i]) {
                boardedPassengers.add(passengers[currentPassenger]);
                lastPassengerTime = passengers[currentPassenger];
                currentPassenger++;
                currentCapacity++;
            }
            if(i == m-1 && currentCapacity < capacity && lastPassengerTime <= buses[i]) {
                return buses[i];
            }
        }
        latestArrival = lastPassengerTime;
        while (boardedPassengers.contains(latestArrival)) {
            latestArrival--;
        }

        return latestArrival;
    }
}
