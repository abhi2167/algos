package com.ds.codewars.UpandDown;

public class UpAndDown {

	public static void main(String[] args){
		
		System.out.println(arrange("who hit retaining The That a we taken")); //on <= I >= came <= up >= were <= so >= grandmothers
		
	}
	
	public static String arrange(String strng) {
        // your code
		String []str = strng.split("\\s++");
		int j=0;
		while(j < 10){
			
			j++;
		}while(j<10)
		for(int i=0;i<str.length-1;i++){
				if(i%2 == 0){
					if(!(str[i].length() <= str[i+1].length())) {
						String temp = str[i];
						str[i] = str[i+1].toLowerCase();
						str[i+1] = temp.toUpperCase();
					} else {
						str[i] = str[i].toLowerCase();
						str[i+1] = str[i+1].toUpperCase();
					}
				} else {
					if(!(str[i].length() >= str[i+1].length())) {
						String temp = str[i];
						str[i] = str[i+1].toUpperCase();
						str[i+1] = temp.toLowerCase();
					} else {
						str[i] = str[i].toUpperCase();
						str[i+1] = str[i+1].toLowerCase();
					}
				}
		}
		return String.join(" ", str).trim();
    }
	
	public static String arrangeBest(String strng) {
        String[] arr = strng.toLowerCase().split(" ");
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.length() > arr[i - 1].length() && i % 2 == 0 || temp.length() < arr[i - 1].length() && i % 2 != 0) {
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        for (int i = 1; i < arr.length; i += 2)
            arr[i] = arr[i].toUpperCase();
        return String.join(" ", arr);
    }
}
