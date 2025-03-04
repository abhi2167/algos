package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MinConsecutiveCardsToPick {

    public static void main(String[] args) {
        MinConsecutiveCardsToPick o = new MinConsecutiveCardsToPick();
        int[] cards = {3,4,2,3,4,7};
        System.out.println("min cards to pick up for matching cards = " + o.minimumCardPickup(cards));
    }

    public int minimumCardPickup(int[] cards) {

        Set<Integer> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int minCards = -1;
        while(right < cards.length) {
            int currentCard = cards[right];
            while(seen.contains(currentCard)) {
                if(minCards == -1 || right - left + 1 < minCards) {
                    minCards = right - left + 1;
                }
                int leftMostCard = cards[left];
                seen.remove(leftMostCard);
                left++;
            }
            seen.add(currentCard);
            right++;
        }
        return minCards;
    }
}
