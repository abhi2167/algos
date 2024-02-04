package com.ds.course.algos.housetheif;

import java.util.Arrays;

public class HouseTheif {
	
	public static void main(String[] args) {
		HouseTheif t = new HouseTheif();
		
		int [] values = {6,7,1,30,8,2,4};
		int [] input2 = {20, 5, 1, 13, 6, 11, 40};
		System.out.println("Result :: " + t.maxHouseValue(values, 0));
		System.out.println("Result :: " + t.maxHouseValue_DC(values, 0, new int[values.length+1]));

	}
	
	private int maxHouseValue(int []arr, int index) {
		if(index >= arr.length) return 0;
		int v1WithCurrentHouse = arr[index] + maxHouseValue(arr, index + 2);
		int v1WithoutCurrentHouse = maxHouseValue(arr, index + 1);
		return Math.max(v1WithCurrentHouse, v1WithoutCurrentHouse);
	}

	private int maxHouseValue_DC(int []arr, int index, int[] dp) {
		if(index >= arr.length) {
			return 0;
		}
		if(dp[index] == 0) {
			int v1WithCurrentHouse = arr[index] + maxHouseValue_DC(arr, index + 2, dp);
			int v1WithoutCurrentHouse = maxHouseValue_DC(arr, index + 1, dp);
			dp[index] = Math.max(v1WithCurrentHouse, v1WithoutCurrentHouse);
			System.out.println(Arrays.toString(dp));
		}
		return dp[index];
	}

}
