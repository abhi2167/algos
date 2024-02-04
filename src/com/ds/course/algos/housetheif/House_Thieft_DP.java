package com.ds.course.algos.housetheif;

import java.util.Arrays;

public class House_Thieft_DP {

	public int maxMoney(int[] HouseNetWorth) {
		int [] dp = new int[HouseNetWorth.length];
		return maxMoneyRecursive(HouseNetWorth, 0, dp);
	}//end of method

	private int maxMoneyRecursive(int[] HouseNetWorth, int currentIndex, int[] dp) {
		if (currentIndex >= HouseNetWorth.length) 
			return 0;
		System.out.println(currentIndex + " " + Arrays.toString(dp));
		if(dp[currentIndex] == 0) {
			int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(HouseNetWorth, currentIndex + 2, dp);			
			int skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex + 1, dp);
			dp[currentIndex] = Math.max(stealCurrentHouse, skipCurrentHouse);
			
		}
		return dp[currentIndex];
	}//end of method

	public static void main(String[] args) {
		House_Thieft_DP ht = new House_Thieft_DP();
		int[] HouseNetWorth = {6, 7, 1, 30, 8, 4, 2};
		System.out.println(ht.maxMoney(HouseNetWorth));
		HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println(ht.maxMoney(HouseNetWorth));
		System.out.println(ht.maxMoneyBottomUp(HouseNetWorth));
	}

	private int maxMoneyBottomUp(int [] houseWorth) {
		int []dp = new int[houseWorth.length + 2];
		dp[dp.length-1] = dp[dp.length-2] = 0;
		dp[dp.length-3] = houseWorth[houseWorth.length-1];
		for(int i=houseWorth.length-1; i>=0; i--) {
			dp[i] = Math.max(houseWorth[i] + dp[i+2], dp[i+1]);
		}
		return dp[0];
	}
}// end of class