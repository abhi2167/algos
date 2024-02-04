package com.ds.codewars.salesmantravel;

public class Travel {

	public static void main(String[] args){
		String r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
		System.out.println(travel(r, "OH 43071"));
	}
	
	 public static String travel(String r, String zipcode) {
	        // Your code
		 if(zipcode.isEmpty()){
			 return ":/";
		 }
		 String [] addresses = r.split(",");
		 StringBuilder resultSet = new StringBuilder();
		 StringBuilder streetSet = new StringBuilder();
		 resultSet.append(zipcode+":");
		 streetSet.append("/");
		 for(String s:addresses)
		 {
			if(s.endsWith(zipcode)){
				int firstWord = s.indexOf(' ');
				resultSet.append(s.substring(firstWord,s.length()-8).trim()+",");
				streetSet.append(s.substring(0,firstWord)+",");
				
			}
		 }
		 if(streetSet.length() == 1)
		 {
			 return resultSet.append(streetSet).toString();
		 }
		 return resultSet.substring(0, resultSet.length()-1) + streetSet.substring(0,streetSet.length()-1);
	    }
}
