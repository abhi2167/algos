package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest c = new ThreeSumClosest();
        // -4, -1, 1, 2  1
        // 4,0,5,-5,3,3,0,-4,-5   -2
        int []nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(c.threeSumClosest(nums, target));
        System.out.println("\n\n Binary Search ");
        System.out.println(c.threeSumClosestBs(nums, target));
    }

    // -5,-4,3,4,5

    public int threeSumClosestBs(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0; i < nums.length && result != 0; i++) {
            for(int j=i+1; j < nums.length-1; j++) {
                int compliment = target - nums[i] - nums[j];
                //System.out.println(" compliment " + compliment + " i " + nums[i] + " j "+ nums[j]);
                int mid = Arrays.binarySearch(nums, j+1, nums.length-1,  compliment);
                int high = mid >= 0 ? mid : ~mid;
                int low = high - 1;
                if( high < nums.length && Math.abs(compliment - nums[high]) < Math.abs(result)) {
                    result = compliment - nums[high];
                }
                if(low > j && Math.abs(compliment - nums[low]) < Math.abs(result)) {
                    result = compliment - nums[low];
                }
                //System.out.println(" mid " + mid + " high " + high);
            }
        }
        return target - result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0; i < nums.length && result != 0 ; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("currentindex "+ i + " left " + left + " right "+ right + " sum " + sum);
                if (Math.abs(target - sum) < Math.abs(result)) {
                    result = target - sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                System.out.println(result + " result ");
            }
        }

        return target-result;
    }

}
