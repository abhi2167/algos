package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximizeConfusionOfExam {
    public static void main(String[] args) {
        MaximizeConfusionOfExam o = new MaximizeConfusionOfExam();

        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println("max consecutive answers with same key = " + o.maxConsecutiveAnswers(answerKey, k));
        System.out.println("max consecutive answers with same key = " + o.maxConsecutiveAnswers_slow(answerKey, k));
        System.out.println("max consecutive answers with same key = " + o.maxConsecutiveAnswers_binsearch(answerKey, k));
    }

    public int maxConsecutiveAnswers_binsearch(String answerKey, int k) {

        int low = 1;
        int high = answerKey.length();
        while(low < high) {
            int mid = (low+high+1)/2;
            if(isValid(answerKey, mid, k)) {
                low = mid;
            } else {
                high = mid-1;
            }
        }

        return low;
    }

    private boolean isValid(String answerKey, int strLen, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < answerKey.length()) {
            char currentChar = answerKey.charAt(right);
            charMap.put(currentChar, charMap.getOrDefault(currentChar, 0)+1);
            if(right - left + 1 > strLen) {
                char leftChar = answerKey.charAt(left);
                charMap.put(leftChar, charMap.get(leftChar)-1);
                if(charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }
                left++;
            }
            if(right-left+1 == strLen && Math.min(charMap.getOrDefault('T', 0), charMap.getOrDefault('F', 0)) <= k) {
                return true;
            }
            right++;
        }
        return false;
    }

    public int maxConsecutiveAnswers_slow(String answerKey, int k) {

        int maxConsecutiveLen = 0;
        char []answers = {'T','F'};
        for(char ans : answers) {
            int left = 0;
            int right = 0;
            int op = 0;
            while(right < answerKey.length()) {
                if(answerKey.charAt(right) != ans) {
                    op++;
                }
                while(op > k) {
                    char ansAtLeft = answerKey.charAt(left);
                    op -= ansAtLeft != ans ? 1 : 0;
                    left++;
                }
                maxConsecutiveLen = Math.max(maxConsecutiveLen, right-left+1);
                right++;
            }
        }

        return maxConsecutiveLen;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int keyFreq[] = new int[125];
        int maxConsecutiveLen = 0;
        while(right < answerKey.length()) {
            int currentAns = answerKey.charAt(right) - 'A';
            keyFreq[currentAns]++;
            maxFreq = Math.max(maxFreq, keyFreq[currentAns]);
            boolean isWindowValid = (right - left + 1 - maxFreq) <= k;
            if(!isWindowValid) {
                int ansAtLeft = answerKey.charAt(left) - 'A';
                keyFreq[ansAtLeft]--;
                left++;
            }
            maxConsecutiveLen = right - left + 1;
            right++;
        }
        return maxConsecutiveLen;
    }

}
