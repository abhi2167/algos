package com.ds.leetcode.easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();

        String s = "   fly me   to   the moon  ";
        System.out.println("Length of last word = " + l.lengthOfLastWord(s));
        System.out.println("Length of last word2 = " + l.lengthOfLastWord2(s));

    }

    public int lengthOfLastWord(String s) {
        int begin=0;
        int end=0;
        for(int i=s.length()-1; i >=0;i--) {
            if(s.charAt(i) != ' ') {
                end = i+1;
                break;
            }
        }
        for(int i = 0; i < end;i++) {
            if(s.charAt(i) == ' ') {
                begin = i+1;
            }
        }
        System.out.println(begin + " " + end);
        return s.substring(begin, end).length();
    }

    public int lengthOfLastWord2(String s) {
        int begin=0;
        int end=0;
        boolean isEndFound = false;
        for(int i=s.length()-1; i >=0;i--) {
            if(s.charAt(i) != ' ' && !isEndFound) {
                end = i+1;
                isEndFound = true;
            }
            if(isEndFound && s.charAt(i) == ' ') {
                begin = i+1;
                break;
            }
        }
        return s.substring(begin, end).length();
    }
}
