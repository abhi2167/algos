package com.ds.codewars.addshiftedarray;

import java.util.Arrays;

public class AddShiftedArray {

	public static void main(String[] args){
		int [][]arrayOfArrays = new int[][] { new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 7, 7, 7, 7, 7, 7 }};
		int a[] = addingShifted(arrayOfArrays, 3);
		System.out.println("\n"+Arrays.toString(a));
	}
	
	public static int[] addingShifted(int[][] arrayOfArrays, int shift) {
		int iterationLength = arrayOfArrays[0].length + (shift * (arrayOfArrays.length-1));
		int result [] = new int[iterationLength];
		System.out.println(Arrays.toString(result));
		
		for(int i=0;i<arrayOfArrays.length;i++) {
			//add arrays i , result
			for(int j=i+1;j<shift*j;j++){
				
			}
			
			result = getArraySum(result, arrayOfArrays[i]);
		}
		return result;
	}
	
	public static int[] getArraySum(int result[],int a[]){
		int arraySum[] = new int[result.length];
		for(int i=0;i<a.length;i++){
			arraySum[i] = a[i] + result[i];
		}
		return arraySum;
	}
}
