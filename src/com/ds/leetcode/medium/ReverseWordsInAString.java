package com.ds.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString r = new ReverseWordsInAString();
        String s = "the sky is blue";
        System.out.println("Reverse of string words = " + r.reverseWords(s));
        System.out.println("Reverse of string words = " + r.reverseWords_lib_methods(s));
    }

    public String reverseWords_lib_methods(String s) {
        List<String> words = Stream.of(s.trim().split("\\s+"))
                .collect(Collectors.toList());
        Collections.reverse(words);
        return words.stream().collect(Collectors.joining(" "));
    }
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int wordBegin = -1;
        int wordEnd = -1;
        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                if(wordBegin == -1) {
                    wordBegin = i;
                    wordEnd = i+1;
                } else {
                    wordEnd = i+1;
                }
            } else {
                if(wordBegin != -1) {
                    words.add(s.substring(wordBegin, wordEnd));
                    wordBegin = -1;
                    wordEnd = -1;
                }
            }
        }
        if(wordBegin != -1) {
            words.add(s.substring(wordBegin, wordEnd));
        }
        StringBuilder result = new StringBuilder();
        for(int i = words.size()-1; i >=0; i--) {
            result.append(words.get(i));
            if(i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
