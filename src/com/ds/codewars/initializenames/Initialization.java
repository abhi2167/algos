package com.ds.codewars.initializenames;

public class Initialization {

	public static void main(String[] args){
		System.out.println(bestInitializeNames("Alice Betty Catherine Davis"));
		
	}
	
	public static String InitializeNames(String name)
	  {
	    String result="";
	    String []str = name.split("\\s++");
	    int len = str.length;
	    if(len<=2){
	    	return name;
	    }
	    result +=str[0] +" ";
	    for(int i=1;i<len-1;i++){
	    	result += str[i].toUpperCase().charAt(0) + ". ";
	    }
	    result += str[len-1];
	    
		return result;
	    
	  }
	public static String bestInitializeNames(String name){
		String []names = name.split("\\s++");
		int len = names.length;
		if(len<=2){
			return name;
		}
		for(int i=1;i<len-1;i++){
			names[i] = names[i].charAt(0) +".";
		}
		return String.join(" ", names);
	}
}
