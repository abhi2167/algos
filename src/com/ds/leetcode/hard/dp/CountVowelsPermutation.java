package com.ds.leetcode.hard.dp;

import java.util.ArrayList;
import java.util.List;

public class CountVowelsPermutation {

    public static void main(String[] args) {
        CountVowelsPermutation c = new CountVowelsPermutation();
        int n = 3;
        System.out.println("Number of vowel permutations = " + c.countVowelPermutation(n));
        System.out.println("Number of vowel permutations = " + c.countVowelPermutation2(n));
        System.out.println("Number of vowel permutations bu = " + c.countVowelPermutation_bu(n));
    }

    public int countVowelPermutation_bu(int n) {
        long aCount = 1L;
        long eCount = 1L;
        long iCount = 1L;
        long oCount = 1L;
        long uCount = 1L;
        int mod = 10^9+7;
        long aCountNew = 0L;
        long eCountNew = 0L;
        long iCountNew = 0L;
        long oCountNew = 0L;
        long uCountNew = 0L;
        
        for(int i=1; i < n; i++) {
            aCountNew = (eCount + iCount + uCount) % mod;
            eCountNew = (aCount + iCount) % mod;
            iCountNew = (eCount + oCount) % mod;
            oCountNew = (iCount) % mod;
            uCountNew = (iCount + oCount) % mod;
            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }
        long result = (aCount + eCount + iCount + oCount + uCount ) % mod;
        return (int)result;
    }

    public int countVowelPermutation(int n) {
        char[] vowels = new char[]{'a','e','i','o','u'};
        List<Character> words = new ArrayList<>();
        for(char vowel : vowels) {
            words.add(vowel);
        }
        for(int i = 2; i <= n; i++) {
            List<Character> nextChars = new ArrayList<>();
            for(char lastChar: words) {
                for(char vowel : vowels) {
                    if(lastChar == 'a' && vowel == 'e') {
                        nextChars.add(vowel);
                    } else if(lastChar == 'e' && (vowel == 'a' || vowel == 'i')) {
                        nextChars.add(vowel);
                    } else if(lastChar == 'i' && vowel != 'i') {
                        nextChars.add(vowel);
                    } else if(lastChar == 'o' && (vowel == 'i' || vowel == 'u')) {
                        nextChars.add(vowel);
                    } else if(lastChar == 'u' && vowel == 'a') {
                        nextChars.add(vowel);
                    }
                }
            }
            words = nextChars;
        }
        System.out.println(words);
        return words.size();
    }

    public int countVowelPermutation2(int n) {
        char[] vowels = new char[]{'a','e','i','o','u'};
        List<String> words = new ArrayList<>();
        for(char vowel : vowels) {
            words.add(String.valueOf(vowel));
        }
        for(int i = 2; i <= n; i++) {
            List<String> nextWords = new ArrayList<>();
            for(String word: words) {
                char lastChar = word.charAt(word.length()-1);
                for(char vowel : vowels) {
                    if(lastChar == 'a' && vowel == 'e') {
                        nextWords.add(word + vowel);
                    } else if(lastChar == 'e' && (vowel == 'a' || vowel == 'i')) {
                        nextWords.add(word + vowel);
                    } else if(lastChar == 'i' && vowel != 'i') {
                        nextWords.add(word + vowel);
                    } else if(lastChar == 'o' && (vowel == 'i' || vowel == 'u')) {
                        nextWords.add(word + vowel);
                    } else if(lastChar == 'u' && vowel == 'a') {
                        nextWords.add(word + vowel);
                    }

                }
            }
            words = nextWords;
        }
        System.out.println(words);
        return words.size();
    }
}
