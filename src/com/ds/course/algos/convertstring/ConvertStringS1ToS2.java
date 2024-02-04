package com.ds.course.algos.convertstring;

public class ConvertStringS1ToS2 {
	
	public static void main(String[] args) {
		ConvertStringS1ToS2 c = new ConvertStringS1ToS2();
		String s1 = "table";
		String s2 = "tbres";
		System.out.println(c.convertString(s1, s2, 0, 0));
		
	}
	
	private int convertString(String s1, String s2, int i1, int i2) {
		if(i1 >= s1.length()) {
			return s2.length() - i2;
		}
		if(i2 >= s2.length()) {
			return s1.length() - i1;
		}
		if(s1.charAt(i1) == s2.charAt(i2)) {
			return convertString(s1, s2, i1 + 1, i2 + 1);
		}
		int insert = 1 + convertString(s1, s2, i1+1, i2);
		int delete = 1 + convertString(s1, s2, i1, i2 + 1);
		int replace = 1 + convertString(s1, s2, i1+1, i2+1);
		return Math.min(insert, Math.min(delete, replace));
	}

}
