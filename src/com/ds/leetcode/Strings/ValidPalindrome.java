package com.ds.leetcode.Strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "Marge, let's \"[went].\" I await {news} telegram.";
        System.out.println(" Valid Palindrome result = " + v.isPalindrome(s));
        System.out.println(" Valid Palindrome result = " + v.isPalindrome2(s));
    }


    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right) {
            if(!isValidChar(chars[left])) {
                left++;
                continue;
            }
            if(!isValidChar(chars[right])) {
                right--;
                continue;
            }
            if(isUpperCase(chars[left])) {
                chars[left] = (char) (chars[left] + 32);
            }
            if(isUpperCase(chars[right])) {
                chars[right] = (char) (chars[right] + 32);
            }
            if(chars[left] != chars[right]) {
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isUpperCase(char ch) {
        return ch >= 65 && ch <= 90;
    }
    private boolean isValidChar(char ch) {
        return (ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122 );
    }
    public boolean isPalindrome(String s) {
        String normalizedPhrase = normalizePhrase(s);
        System.out.println(normalizedPhrase);
        int start = 0;
        int end = normalizedPhrase.length()-1;
        while(start < end) {
            if(normalizedPhrase.charAt(start) != normalizedPhrase.charAt(end)) {
                return  false;
            }
            start++;
            end--;
        }
        return true;
    }

    private String normalizePhrase(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122 )) {
                System.out.println("valid char " + ch);
                if(ch >= 65 && ch <= 91) {
                    str.setCharAt(i, (char) (ch+32));
                }
                i++;
            } else {
                str.deleteCharAt(i);
            }
        }
        return str.toString();
    }
}
