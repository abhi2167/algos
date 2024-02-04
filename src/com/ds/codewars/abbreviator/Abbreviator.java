package com.ds.codewars.abbreviator;

public class Abbreviator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Abbreviator abbreviator = new Abbreviator();
		System.out.println(abbreviator.abbreviate("You need need not want to complete"));
		//System.out.println(abbreviator.abbreviate("elephant-ride need the"));
	}
	
	 public String abbreviate(String string) {
		    // ...
		 String []str = string.trim().split("\\s+|\\-");
		 String result="";
		 for(int i=0;i<str.length;i++) {
			 if(str[i].length()>=4){
				 char firstChar = str[i].charAt(0);
				 char lastChar = str[i].charAt(str[i].length()-1);
				 int numberOfChar = str[i].length()-2;
				 result += firstChar + String.valueOf(numberOfChar)  + lastChar + string.charAt(getNextChar(str,i));
			 }
			 else {
				 result += str[i] + " ";
			 }
		 }
		    return result.trim();
		  }
	 public int getNextChar(String []str,int i){
		 int length = 0;
		 for(int j=0;j<=i;j++){
			 length += str[j].length()+1;
		 }
		 return length;
	 }
}
