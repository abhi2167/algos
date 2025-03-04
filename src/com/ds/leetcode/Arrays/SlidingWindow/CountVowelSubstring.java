package com.ds.leetcode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountVowelSubstring {

    public static void main(String[] args) {
        CountVowelSubstring o = new CountVowelSubstring();
        String word = "cuaieuouac";
        System.out.println("No of substring with only vowels = " + o.countVowelSubstrings(word));
        System.out.println("No of substring with only vowels = " + o.countVowelSubstrings2(word));
    }

        public int countVowelSubstrings2(String word) {
            int vow = 0;  // Counter for distinct vowels
            int cnt = 0;  // Result counter for valid substrings
            Map<Character, Integer> vowelMap = new HashMap<>();
            String vowels = "aeiou";  // String containing all vowels

            // Initialize the map with vowel characters and set counts to 0
            for (char c : vowels.toCharArray()) {
                vowelMap.put(c, 0);
            }

            for (int i = 0, j = 0, k = 0; i < word.length(); ++i) {
                char currentChar = word.charAt(i);
                if (vowelMap.containsKey(currentChar)) {  // Check if the character is a vowel
                    vowelMap.put(currentChar, vowelMap.get(currentChar) + 1);
                    if (vowelMap.get(currentChar) == 1) {
                        vow++;  // Increment vow if it's a new vowel
                    }

                    // Adjust k to maintain exactly 5 distinct vowels
                    while (vow == 5) {
                        char startChar = word.charAt(k++);
                        vowelMap.put(startChar, vowelMap.get(startChar) - 1);
                        if (vowelMap.get(startChar) == 0) {
                            vow--;  // Decrease vow if a vowel count goes to 0
                        }
                    }
                    cnt += k - j;  // Count valid substrings ending at i
                } else {
                    // Reset if a consonant is found
                    for (char c : vowels.toCharArray()) {
                        vowelMap.put(c, 0);
                    }
                    vow = 0;
                    j = k = i + 1;  // Move the start pointers past the current position
                }
            }

            return cnt;
        }

    public int countVowelSubstrings(String word) {
        int left = 0;
        int mid = 0;
        int right = 0;
        int totalSubArrays = 0;
        HashMap<Character, Integer> vowelFreq = new HashMap<>();
        while(right < word.length()) {
            char currentCh = word.charAt(right);
            if(isVowel(currentCh)) {
                vowelFreq.put(currentCh, vowelFreq.getOrDefault(currentCh, 0) + 1);
                while(vowelFreq.size() == 5) {
                    char leftCh = word.charAt(mid);
                    vowelFreq.put(leftCh, vowelFreq.getOrDefault(leftCh, 0)-1);
                    if(vowelFreq.get(leftCh).intValue() == 0) {
                        vowelFreq.remove(leftCh);
                    }
                    mid++;
                }
                totalSubArrays += mid - left;
            } else {
                left = mid = right+1;
                vowelFreq.clear();
            }
            right++;
        }
        return totalSubArrays;
    }

    private boolean isVowel(char currentCh) {
        return currentCh == 'a' || currentCh == 'e' || currentCh == 'i' || currentCh == 'o' || currentCh == 'u';
    }
}
