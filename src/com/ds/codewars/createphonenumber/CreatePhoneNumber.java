package com.ds.codewars.createphonenumber;

public class CreatePhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(createPhoneNubmerBest(new int[]{1,2,3,4,5,6,7,8,9,0}));
	}

	public static String createPhoneNumber(int[] numbers) {
	    // Your code here!
		String result = "";
		for(int i=0;i<numbers.length;i++){
			if(i==0){
				result+="(";
			}
			if(i==3){
				result+=") ";
			}
			if(i==6){
				result+="-";
			}
			result+=String.valueOf(numbers[i]);
		}
		return result;
	  }
	public static String createPhoneNubmerBest(int[] numbers){
		return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
	}
}
