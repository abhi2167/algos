package com.ds.leetcode.hard.dp;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class MinimumCandiesToDistribute {

    public static void main(String[] args) {
        MinimumCandiesToDistribute m = new MinimumCandiesToDistribute();
        int [] ratings = {1,2,3,2,0};
        System.out.println("Minimum candies = " + m.candy(ratings));
        System.out.println("Minimum candies = " + m.candy_two_arrays(ratings));
    }

    public int candy(int[] ratings) {

        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        while(hasChanged) {
            hasChanged = false;
            for(int i = 0; i < ratings.length; i++) {
                if( i != candies.length-1
                        && ratings[i] > ratings[i+1]
                        && candies[i] <= candies[i+1] )   {
                    candies[i] = 1 + candies[i+1];
                    hasChanged = true;
                }
                if(i > 0 && ratings[i] > ratings[i-1]
                            && candies[i] <= candies[i-1]) {
                    candies[i] = 1 + candies[i-1];
                    hasChanged = true;
                }
            }
        }

        return Arrays.stream(candies).sum();
    }

    public int candy_two_arrays(int[] ratings) {

        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = 1 + candies[i-1];
            }
        }

        for(int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = 1 + candies[i+1];
            }
        }

        System.out.println(Arrays.toString(candies));


        return Arrays.stream(candies).sum();
    }
}
