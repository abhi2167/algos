package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.*;

public class FindSubstringFromWords {

    public static void main(String[] args) {
        FindSubstringFromWords f = new FindSubstringFromWords();
        String s = "barfoofoobarthefoobarman";
        String[] words = {"foo","bar", "the"};
        System.out.println(" Result == " + f.findSubstring(s, words));
        System.out.println(" Result == " + f.findSubstring2(s, words));
    }

    private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    private int n;
    private int wordLength;
    private int substringSize;
    private int k;

    private void slidingWindow(int left, String s, List<Integer> answer) {
        HashMap<String, Integer> wordsFound = new HashMap<>();
        int wordsUsed = 0;
        boolean excessWord = false;

        // Do the same iteration pattern as the previous approach - iterate
        // word_length at a time, and at each iteration we focus on one word
        for (int right = left; right <= n - wordLength; right += wordLength) {
            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                // Mismatched word - reset the window
                wordsFound.clear();
                wordsUsed = 0;
                excessWord = false;
                left = right + wordLength;
            } else {
                // If we reached max window size or have an excess word
                while (right - left == substringSize || excessWord) {
                    String leftmostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordsFound.put(
                            leftmostWord,
                            wordsFound.get(leftmostWord) - 1
                    );

                    if (
                            wordsFound.get(leftmostWord) >=
                                    wordCount.get(leftmostWord)
                    ) {
                        // This word was an excess word
                        excessWord = false;
                    } else {
                        // Otherwise we actually needed it
                        wordsUsed--;
                    }
                }

                // Keep track of how many times this word occurs in the window
                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                if (wordsFound.get(sub) <= wordCount.get(sub)) {
                    wordsUsed++;
                } else {
                    // Found too many instances already
                    excessWord = true;
                }

                if (wordsUsed == k && !excessWord) {
                    // Found a valid substring
                    answer.add(left);
                }
            }
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, answer);
        }

        return answer;
    }

    Map<String, Integer> wordBank = new HashMap<>();
    public List<Integer> findSubstring2(String s, String[] words) {
        int wordLength = words[0].length();
        int wordsLength = words.length;
        int subStrLength = wordLength * wordsLength;
        List<Integer> result = new ArrayList<>();
        for(String word: words) {
            wordBank.put(word, wordBank.getOrDefault(word,0)+1);
        }
        for(int i=0; i <= s.length()-subStrLength; i++) {
            if(isValidSubString(i, s, wordsLength, wordLength, subStrLength)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isValidSubString(int currentIndex, String s, int wordsLength, int wordLength, int subStrLength) {

        Map<String, Integer> remaining = new HashMap<>(wordBank);
        int wordsUsed = 0;
        for(int i = currentIndex; i < currentIndex+subStrLength; i += wordLength) {
            String subStr = s.substring(i, i+wordLength);
            if(remaining.getOrDefault(subStr, 0) != 0) {
                remaining.put(subStr, remaining.get(subStr)-1);
                wordsUsed++;
            } else {
                break;
            }
        }
        return wordsUsed == wordsLength;
    }


}
