package com.ds.codewars.sort.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortString sortString = new SortString();
		System.out.println(sortString.getResultString(sortString.getWordsMap((("is2 Thi1s T4est 3a").split("\\s++")))));
	}
	
	public Map<Integer,String> getWordsMap(String[] stringArray){
		HashMap<Integer,String> wordsMap = new HashMap<Integer,String>();
		for(int i=0;i<stringArray.length;i++){
			String tempStr = stringArray[i]; 
			for(int j=0;j<tempStr.length();j++){
				if(Character.isDigit(tempStr.charAt(j))){
					int a = Integer.parseInt(String.valueOf(tempStr.charAt(j)));
					wordsMap.put(a, tempStr);
				}
			}
		}
		return wordsMap;
	}

	public String getResultString(Map<Integer,String> stringMap) {
		ArrayList<Integer> list =  new ArrayList<Integer>(stringMap.keySet());
		Collections.sort(list);
		String finalStr = "";
		for(Integer l:list){
			finalStr +=stringMap.get(l)+" ";
		}
		return finalStr.trim();
	}
}
