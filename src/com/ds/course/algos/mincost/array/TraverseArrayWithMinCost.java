package com.ds.course.algos.mincost.array;

import java.util.Arrays;

public class TraverseArrayWithMinCost {

	private static int counter1 = 0;
	private static int counter2 = 0;
	
	public static void main(String[] args) {
		TraverseArrayWithMinCost m = new TraverseArrayWithMinCost();
		int [][] items = {{4,7,8,6,4},{6,7,3,9,2},{3,8,1,2,4},{7,1,7,3,7},{2,9,8,9,3}};
		for(int [] array : items) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println("=======Result :: " + m.minCostToReachEnd(items, items.length-1, items[items.length-1].length-1));
		System.out.println("========Result :: " + m.minCostToReachEnd2(items, 0, 0));
		System.out.println("========Total iterations  :: counter1 : " + counter1 + " counter2: "+ counter2);
	}

	private int minCostToReachEnd2(int [][] items, int i, int j) {
		counter2++;
		//if(i != -1 && j != -1)
		System.out.println("index " + i + " " + j);
		if(i >= items.length || j >= items[i].length)
			return Integer.MAX_VALUE;
		if(i == items.length-1 && j == items[i].length-1 )
			return items[items.length-1][items[i].length-1];
		int c1 = minCostToReachEnd2(items, i, j+1);
		System.out.println("cost c1 " + c1 + " " + i + " " + j);
		int c2 = minCostToReachEnd2(items, i+1, j);
		System.out.println("cost c2 " + c2 + " " + i + " " + j);
		return Math.min(c1, c2) + items[i][j];
	}

	private int minCostToReachEnd(int [][] items, int i, int j) {
		counter1++;
		//if(i != -1 && j != -1)
			System.out.println("index " + i + " " + j);
		if(i == -1 || j== -1)
			return Integer.MAX_VALUE;
		if(i == 0 && j == 0 )
			return items[0][0];
		int c1 = minCostToReachEnd(items, i-1, j);
		System.out.println("cost c1 " + c1 + " " + i + " " + j);
		int c2 = minCostToReachEnd(items, i, j-1);
		System.out.println("cost c2 " + c2 + " " + i + " " + j);
		return Math.min(c1, c2) + items[i][j];
	}
}
