package com.ds.course.algos.knapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FractionalKnapSackProblem {
	
	public static void main(String[] args) {
		FractionalKnapSackProblem p = new FractionalKnapSackProblem();
		
		int [][]items = {{6,6},{2,10},{1,3},{8,5},{3,1},{5,3}};
		
		System.out.println("Value :: Weight");
		for(int i=0; i < items.length; i++)
			System.out.print(Arrays.toString(items[i]) + "  ");
		
		System.out.println("\n Result :: " + p.knapsack(10, items));
	}

	private double knapsack(int capacity, int [][] items) {
		double totalWeight = 0;
		double totalValue = 0;
		double []ratios = new double[items.length];
		Map<Double, Integer> ratioToIndex = new TreeMap<>((o1,o2) -> o2 > o1 ? 1 : o2 < o1 ? -1 : 0 );
		for(int i=0; i < items.length; i++) {
			double ratio = (items[i][0] * 1.0)/items[i][1];
			ratioToIndex.put(ratio, i);
		}
		System.out.println("\n Ratios :: " + ratioToIndex);
		
		for(Map.Entry<Double, Integer> entry : ratioToIndex.entrySet()) {
			int index = entry.getValue();
			
			if(totalWeight + items[index][1] <= capacity) {
				System.out.println("item " + items[index][0] + " " + items[index][1]);
				totalWeight += items[index][1];
				totalValue += items[index][0];
			} else {
				System.out.println("item " + items[index][0] + " " + items[index][1]);
				double remainingWeight = capacity - totalWeight;
				totalWeight += (remainingWeight * 1.0)/entry.getKey();
				totalValue += remainingWeight * (items[index][0]/items[index][1]);
				break;
			}
		}
		System.out.println("total weight " + totalWeight + " total value " + totalValue);
		return totalValue;
	}
}
