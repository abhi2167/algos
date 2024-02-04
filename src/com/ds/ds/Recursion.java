package com.ds.ds;

import java.util.Arrays;
import java.util.List;

public class Recursion {

	public static String cutThemAll(List<Integer> list, long minLength) {

		boolean hasPair = false;
		for (int i = 0, j= i+1; j < list.size(); i++,j++) {
			if (list.get(i) + list.get(j) >= minLength) {
				hasPair = true;
			}
		}
		if (!hasPair) {
			return "Impossible";
		} else {
			return "Possible";
		}
	}

	public static String cutThemAllR(List<Integer> list, long minLength) {
	    long totalLength = list.stream().mapToLong(i -> i).sum();
	    if(list.size() == 2) {
	        if (totalLength >= minLength) {
	            return "Possible";
	        } else {
	            return "Impossible";
	        }
	    } else {
	        return cutThemAllR(list.subList(0, list.size()-1), minLength);
	    }
	}
	public static void main(String[] args) {

		System.out.println(cutThemAll(Arrays.asList(1, 3, 4, 2, 3), 5));
		System.out.println(cutThemAllR(Arrays.asList(3, 2, 5, 6, 1), 8));
	}
	
	/**
	 * list = [2,4,1,2], minLength = 6
	 */
//	public static String cutThemAll(List<Integer> list, long minLength) {
//	    
//	}
	
	
}
