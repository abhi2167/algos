package com.ds.codewars.compare.strings;

public class CompareStrings {

	public static void main(String[] args){
		System.out.println(compare("AD", "BC"));
	}
	
	public static Boolean compare(String s1, String s2)
	 {  
		if(String.valueOf(s1).equals(s2))
		    	return true;
		if(s1 == null || s1.isEmpty() || !s1.matches("[a-zA-Z]+")) {
			if(s2 == null || s2.isEmpty() || !s2.matches("[a-zA-Z]+")){
				return true;
			}
			return false;
		}
		String s3 = s1.toUpperCase();
		String s4 = s2.toUpperCase();
		int s1Value = 0;
		int s2Value = 0;
		System.out.println(s1.toUpperCase().chars().sum());
		for(int i=0;i<s3.length();i++){
			s1Value += s3.codePointAt(i);
		}
		for(int j=0;j<s4.length();j++){
			s2Value += s4.codePointAt(j);
		}
		if(s1Value == s2Value)
			return true;
		return false;
	 }
	
	public static Boolean compareBest(String s1, String s2)
	  {    
	    s1 = (s1 == null) ? "" : s1;
	    s2 = (s2 == null) ? "" : s2;
	    return s1.replaceAll(".*[^a-zA-Z].*", "").toUpperCase().chars().sum() == s2
	                .replaceAll(".*[^a-zA-Z].*", "").toUpperCase().chars().sum();
	  }
}
