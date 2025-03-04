package com.ds.leetcode.Arrays.twopointers;

public class AreSentencesEqual {

    public static void main(String[] args) {
        AreSentencesEqual o = new AreSentencesEqual();
        String s1 = "Frog cool";
        String s2 = "Frogs are cool";
        System.out.println(" Are senetences equal = " + o.areSentencesSimilar(s1, s2));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length()) {
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int left = 0;
        int right = words1.length - 1;
        int right2 = words2.length - 1;
        while(left <= right) {
            if(!words1[left].equals(words2[left])  &&
                    !words1[right].equals(words2[right2])) {
                return false;
            }
            while(left <= right && words1[left].equals(words2[left])) {
                left++;
            }
            while(right >= left && words1[right].equals(words2[right2])) {
                right--;
                right2--;
            }
        }
        return left > right;
    }
}
