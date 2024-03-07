package com.ds.leetcode.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MinJumpsToReachHome {
    public static void main(String[] args) {
        MinJumpsToReachHome j = new MinJumpsToReachHome();
        int [] forbidden = {1,6,2,14,5,17,4};
        int a = 16;
        int b = 9;
        int x = 7;
        System.out.println("minimum jumps to reach " + j.minimumJumps(forbidden, a, b, x));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int maxLimit = a >= b ? x + b*2 : 2000 + b*2;
        queue.add(new int[]{0,0});
        HashSet<String> visited = new HashSet<>();
        HashSet<Integer> forbiddenSet = new HashSet<>();
        for(int i : forbidden) {
            forbiddenSet.add(i);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int [] curr = queue.poll();
                int n = curr[0];
                int direction = curr[1];
                if(n == x) {
                    return count;
                }
                int forwardJump = n + a;
                if(forwardJump < maxLimit && !visited.contains(forwardJump+","+0) && !forbiddenSet.contains(forwardJump)) {
                    queue.add(new int[]{forwardJump, 0});
                    visited.add(forwardJump+","+0);
                }
                if(direction == 0) {
                    int backwardJump = n - b;
                    if(backwardJump >= 0 && !visited.contains(backwardJump+","+1) && !forbiddenSet.contains(backwardJump)) {
                        queue.add(new int[]{backwardJump, 1});
                        visited.add(backwardJump+","+1);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
