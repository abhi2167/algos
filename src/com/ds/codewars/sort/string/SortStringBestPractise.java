package com.ds.codewars.sort.string;

import java.util.Arrays;

public class SortStringBestPractise {

	public static String order2(String words) {
        String[] arr = words.split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < 10; i++) {
            for (String s : arr) {
                if (s.contains(String.valueOf(i))) {
                    result.append(s + " ");
                }
            }
        }
        return result.toString().trim();
    }
	
	 public static String order1(String words) {
	        String[] strs = words.split(" ");
	        Arrays.sort(strs, (String s1, String s2) -> s1.replaceAll("[a-zA-Z]","").compareTo(s2.replaceAll("[a-zA-Z]",""))  );
	        String f = "";
	        for(String st:strs) f+=st + " ";
	        return f.substring(0,f.length()-1);
	    }
}
