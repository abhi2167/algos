package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {
        FruitsIntoBasket o = new FruitsIntoBasket();
        int[] fruits = {0,1,2,2};
        System.out.println("Max num of fruits that can be picked into baskets = " + o.totalFruit(fruits));
        System.out.println("Max num of fruits that can be picked into baskets eff= " + o.totalFruit_eff(fruits));
        System.out.println("Max num of fruits that can be picked into baskets eff= " + o.totalFruit_eff2(fruits));
    }

    public int totalFruit_eff2(int[] fruits) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> fruitsMap = new HashMap<>();
        int maxFruits = 0;
        while(right < fruits.length) {
            int currentFruit = fruits[right];
            fruitsMap.put(currentFruit, fruitsMap.getOrDefault(currentFruit, 0) + 1);
            while(fruitsMap.size() > 2) {
                int leftMostFruit = fruits[left];
                fruitsMap.put(leftMostFruit, fruitsMap.get(leftMostFruit)-1);
                if(fruitsMap.get(leftMostFruit) == 0) {
                    fruitsMap.remove(leftMostFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
            right++;
        }
        return maxFruits;
    }

    public int totalFruit_eff(int[] fruits) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> fruitsMap = new HashMap<>();
        int maxFruits = 0;
        while(right < fruits.length) {
            int currentFruit = fruits[right];
            fruitsMap.put(currentFruit, right);
            while(fruitsMap.size() > 2) {
                int fruitToRemove = 0;
                for(Map.Entry<Integer, Integer> fruitEntry : fruitsMap.entrySet()) {
                    if(fruitEntry.getKey().intValue() != fruits[right-1] && fruitEntry.getKey().intValue() != currentFruit) {
                        fruitToRemove = fruitEntry.getKey();
                    }
                }
                left = fruitsMap.get(fruitToRemove)+1;
                fruitsMap.remove(fruitToRemove);
            }
            maxFruits = Math.max(maxFruits, right-left+1);
            right++;
        }
        return maxFruits;
    }

    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> fruitsMap = new HashMap<>();
        int maxFruits = 0;
        while(right < fruits.length) {
            int currentFruit = fruits[right];
            fruitsMap.put(currentFruit, fruitsMap.getOrDefault(currentFruit, 0)+1);
            while(fruitsMap.size() > 2) {
                int startFruit = fruits[left];
                fruitsMap.put(startFruit, fruitsMap.get(startFruit)-1);
                if(fruitsMap.get(startFruit) == 0) {
                    fruitsMap.remove(startFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
            right++;
        }
        return maxFruits;
    }
}
