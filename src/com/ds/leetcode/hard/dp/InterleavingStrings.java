package com.ds.leetcode.hard.dp;

public class InterleavingStrings {

    public static void main(String[] args) {
        InterleavingStrings i = new InterleavingStrings();
        String s1 = "ac";
        String s2 = "bd";
        String s3 = "abcd";
        System.out.println("is interleave btf = " + i.isInterleave(s1, s2, s3));
        System.out.println("is interleave btf = " + i.isInterleave_tp2(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return  false;
        return isInterleave(s1, s2, s3, 0, 0, "");
    }

    public boolean isInterleave(String s1, String s2, String s3, int i1, int i2, String res) {
        if(res.equals(s3) && i1 == s1.length() && i2 == s2.length()) {
            return true;
        }
        boolean ans = false;
        if(i1 < s1.length()) {
            ans |= isInterleave(s1, s2, s3, i1+1, i2, res + s1.charAt(i1));
        }
        if(i2 < s2.length()) {
            ans |= isInterleave(s1, s2, s3, i1, i2+1, res + s2.charAt(i2));
        }
        return ans;
    }

    public boolean isInterleave_tp2(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return  false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        return isInterleave_tp2(s1, s2, s3, 0, 0, 0, dp);
    }
    public boolean isInterleave_tp2(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {

        if(i == s1.length()) {
            return dp[i][j] = s2.substring(j).equals(s3.substring(k));

        }
        if(j == s2.length()) {
            return  dp[i][j] = s1.substring(i).equals(s3.substring(k));
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans = false;
        if(s1.charAt(i) == s3.charAt(k) && isInterleave_tp2(s1, s2, s3, i+1, j, k+1, dp)
                || s2.charAt(j) == s3.charAt(k) && isInterleave_tp2(s1, s2, s3, i, j+1, k+1, dp))   {
           ans = true;
        }

        return dp[i][j] = ans;
    }

    public boolean isInterleave_bu(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length())
            return  false;

        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(i ==0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) || dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
