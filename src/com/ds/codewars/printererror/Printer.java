package com.ds.codewars.printererror;

public class Printer {

	public static void main(String[] args){
		System.out.println(printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
	}
	
	public static String printerError(String s) {
        // your code
		int numerator=0;		
		for(int i=0;i<s.length();i++){
			if(!((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 109)){
				numerator++;
			}
		}
		return String.valueOf(numerator + "/"+s.length());
    }
	
	public static String printerErrorBest(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
	
	public static String printerErrorLambda(String s) {
        long errs = s.chars().filter( ch -> ch > 'm').count();
        return errs+"/"+s.length();
    }
}
