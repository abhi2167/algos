package com.ds.leetcode.Arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {


    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
                      //0,1,2,3, 4, 5
                     // -4, -1, -1, 0, 1, 2
        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));
        System.out.println(s.threeSum2(nums));
        System.out.println(s.threeSumHashSet(nums));
        System.out.println(s.threeSumNoSort(nums));
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0; i < nums.length && nums[i] <= 0; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int currentNum = nums[i];
            int left = i + 1;
            int right = nums.length-1;
            int sum = 0;
            while(left < right) {
                int currentCompliment = -nums[i];
                sum = nums[left] + nums[right];
                if( sum == currentCompliment) {
                    triplets.add(Stream.of(currentNum, nums[left], nums[right]).collect(Collectors.toList()));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if (sum > currentCompliment) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }






    // use set of sorted listed to store unique triplets
    // use hashmap with nums[j] as key and i as value.. storing i as value will indicate
    // whether that number has already appeared in current iteration for j
    private List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> seen = new HashMap<>();
        HashSet<Integer> dups = new HashSet<>();
        for(int i=0; i < nums.length; i++) {
            if(dups.add(nums[i])) {
                for(int j= i+1; j < nums.length; j++) {
                    int compliment = -nums[i] - nums[j];
                    if(seen.containsKey(compliment) && seen.get(compliment) == i) {
                        List<Integer> triplets = Arrays.asList(nums[i], nums[j], compliment);
                        Collections.sort(triplets);
                        result.add(triplets);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private List<List<Integer>> threeSumHashSet(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                List<List<Integer>> temp = twoSumHash(nums, i);
                if(!temp.isEmpty())
                    result.addAll(temp);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSumHash(int [] nums, int currentIndex) {
        List<List<Integer>> result = new ArrayList<>();
        int j = currentIndex + 1;
        HashSet<Integer> seen = new HashSet<>();

        while ( j < nums.length) {
            int compliment = -(nums[currentIndex] + nums[j]);
            if(seen.contains(compliment)) {
                // match found
                result.add(Arrays.asList(nums[currentIndex], nums[j], compliment));
                while(j < nums.length && nums[j] == nums[j-1])
                    j++;
            }
            seen.add(nums[j]);
            j++;
        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums.length && nums[i] <=0 ; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
               twoSum(nums, result, i);
            }
        }
        return result;
    }

    private void twoSum(int[] nums, List<List<Integer>> result, int currentIndex) {
        int left = currentIndex + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[currentIndex] + nums[left] + nums[right];
            if(sum > 0) {
                right--;
            } else if(sum < 0) {
                left++;
            } else {
                result.add(Arrays.asList(nums[currentIndex], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1])
                    left++;
            }
        }
    }
}
