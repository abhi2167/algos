package com.ds.course.algos.knapsack;

import java.util.Arrays;

public class ZeroOneKnapsack {
	
	public static void main(String[] args) {
		ZeroOneKnapsack p = new ZeroOneKnapsack();
		
		int [][]items = {{31,3},{26,1},{72,5},{17,2}};
		
		System.out.println("Value :: Weight");
		for(int i=0; i < items.length; i++)
			System.out.print(Arrays.toString(items[i]) + "  ");
		
		System.out.println("\n Result :: " + p.knapsack(7, items, 0));
	}


	private int knapsack(int capacity, int [][]items, int i) {
		System.out.println("capacity " + capacity);
		if(capacity < 0) {
			return 0;
		}
		if(i >= items.length) {
			return 0;
		}
		System.out.println(" i " + i);
		int w1 = 0;
		if(items[i][1] <= capacity)
			w1 = items[i][0] + knapsack(capacity - items[i][1], items, i + 1);
		int w2 = knapsack(capacity, items, i+1);
		return Math.max(w1, w2);
	}
}
