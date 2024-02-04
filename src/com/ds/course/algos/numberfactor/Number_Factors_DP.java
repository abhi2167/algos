package com.ds.course.algos.numberfactor;

public class Number_Factors_DP {

	public int waysToGetN(int n, int []dp) {
		if ((n == 0) || (n == 1) || (n == 2)) // { }, {1}, {1,1}
			return 1; //
		if (n == 3)
			return 2; // {1,1,1}, {3}
		if(dp[n] == 0) {
			int subtract1 = waysToGetN(n - 1, dp); // if we subtract 1, we will be left with 'n-1'
			int subtract3 = waysToGetN(n - 3, dp); // if we subtract 3, we will be left with 'n-3'
			int subtract4 = waysToGetN(n - 4, dp); // if we subtract 4, we will be left with 'n-4'
			dp[n] = subtract1 + subtract3 + subtract4;
		}
		return dp[n];
	}//End of method

	
	public static void main(String[] args) {
		Number_Factors_DP en = new Number_Factors_DP();
		int dp[] = new int[5];
//		dp[0] = dp[1] = dp[2] = 1;
//		dp[3] = 2;
		System.out.println(en.waysToGetN(4, dp));
		dp = new int[6];
//		dp[0] = dp[1] = dp[2] = 1;
//		dp[3] = 2;
		System.out.println(en.waysToGetN(5, dp));
		dp = new int[7];
//		dp[0] = dp[1] = dp[2] = 1;
//		dp[3] = 2;
		System.out.println(en.waysToGetN(6, dp));
		
		System.out.println(en.waysToGetNBottomUp(6));
	}//End of method
	
	
	public int waysToGetNBottomUp(int n) {
		int dp[] = new int[n+1];
		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;
		for(int i = 4; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
		}
		return dp[n];
	}
}//End of Class
