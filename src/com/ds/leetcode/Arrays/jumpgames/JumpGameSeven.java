package com.ds.leetcode.Arrays.jumpgames;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameSeven {

    public static void main(String[] args) {
        //int [] nums = {45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,3,2,1,0,0};
        String s = "000 000 000 0";
        System.out.println("String length " + s.length());
        JumpGameSeven c = new JumpGameSeven();
        System.out.println("Can Jump Result ===> "+ c.canReach(s, 2, 5));
        System.out.println("Can Jump Result ===> "+ c.canReach_bu(s, 2, 5));
        System.out.println("Can Jump Result ===> "+ c.canReach_bu22(s, 2, 5));
    }

    public boolean canReach_bu22(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false; // In case the last character is '1', we'll never be able to reach the end.
        }

        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            System.out.println("Current i " + i);
            if (i > maxJump) {
                count -= dp[i - maxJump - 1] ? 1 : 0; // Moving sliding window forward by decrementing the count by the dp value of the index that is no longer in our window
                System.out.println("Current count decrease " + count);
            }
            if (i >= minJump) {
                count += dp[i - minJump] ? 1 : 0;
                System.out.println("Current count increase " + count);
            }

            dp[i] = (count > 0 && s.charAt(i) == '0');
        }
        return dp[dp.length - 1];
    }

    public boolean canReach_bu(String s, int minJump, int maxJump) {
        int left = 0, right = 0, furthest = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int n = s.length();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == n - 1) {
                return true;
            }
            left = Math.max(minJump + node, furthest);
            right = Math.min(maxJump + node, n - 1);
            for(int i = left; i <= right; i++) {
                if(s.charAt(i) == '0') {
                    queue.add(i);
                }
            }
            furthest = right + 1;
        }
        return false;
    }

    public boolean canReach_bu2(String s, int minJump, int maxJump) {
        if (s.charAt(s.length()-1) != '0')
            return  false;
        boolean [] dp = new boolean[s.length()];
        dp[dp.length-1] = true;
        for(int i = s.length()-2; i >= 0; i--) {
            int furthestMaxJump = Math.min(i + maxJump, s.length()-1);
            int furthestMinJump = minJump + i;
            if(s.charAt(i) != '0')
                continue;
            for(int nextPos = furthestMinJump; nextPos <= furthestMaxJump; nextPos++) {
                if(s.charAt(nextPos) == '0' && dp[nextPos]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }



    public boolean canReach(String s, int minJump, int maxJump) {
        return canJump(s, minJump, maxJump, 0, new boolean[s.length()]);
    }

    private boolean canJump(String s, int minJump, int maxJump, int currentIndex, boolean dp[]) {
        if(currentIndex == s.length()-1 && s.charAt(currentIndex) == '0') {
            return true;
        }
        if(!dp[currentIndex]) {
            int furthestJump = Math.min(currentIndex + maxJump, s.length()-1);
            for(int nextPos = currentIndex + minJump; nextPos <= furthestJump; nextPos++) {
                if (s.charAt(nextPos) == '0' && canJump(s, minJump, maxJump, nextPos, dp)) {
                    dp[currentIndex] = true;
                    return true;
                }
            }
        }
        return false;
    }

}
