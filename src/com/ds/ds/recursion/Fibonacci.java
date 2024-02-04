package com.ds.ds.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
	
	static int counter = 0;
	static Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number in series... \n");
		int n = sc.nextInt();
		System.out.println("Nth number in fibonacci series: "+ findNumberInSeries(n));
		System.out.println("Number of iterations.." + counter);
		counter = 0;
		System.out.println("Nth number in fibonacci series using optimization: "+ findNumberInSeriesOptimized(n));
		System.out.println("Number of iterations.." + counter);
	}
	
	// 0,1,1,2,3,5,8,13,21,34, 55 ....
	
	// n = 3, sum(1)
	// n  = 4, sum(1,sum(0,1))
	//n = 5, sum(n-4, n-3)
	// n =5, sum(2,
	
	
	// 
	
	private static int findNumberInSeriesOptimized(int n) {
		counter++;
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		if(cache.containsKey(n)) {
			return cache.get(n);
		}
		int result =  findNumberInSeriesOptimized(n-1) + findNumberInSeriesOptimized(n-2);
		cache.put(n, result);
		return result;
	}
	
	private static int findNumberInSeries(int n) {
		counter++;
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		int result =  findNumberInSeries(n-1) + findNumberInSeries(n-2);
		return result;
	}

}
