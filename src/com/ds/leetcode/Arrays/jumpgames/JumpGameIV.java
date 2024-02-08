package com.ds.leetcode.Arrays.jumpgames;

import java.util.*;

public class JumpGameIV {
    public static void main(String[] args) {

        int[] nums = {100,-23,-23,404,100,23,23,23,3,404};
        JumpGameIV j = new JumpGameIV();
        System.out.println("Result = " + j.minJumps(nums));
    }

    public int minJumps(int[] arr) {
        Map<Integer, ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                ArrayList<Integer>al=hm.get(arr[i]);
                al.add(i);
                hm.put(arr[i],al);
            }
            else{
                ArrayList<Integer>al=new ArrayList<>();
                al.add(i);
                hm.put(arr[i],al);
            }
        }
        boolean vis[]=new boolean[arr.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int cnt=0;
        while(!q.isEmpty()){
            for(int k=q.size();k>0;k--){
                int n=q.remove();
                vis[n]=true;
                if(n==arr.length-1) return cnt;
                ArrayList<Integer>al=hm.get(arr[n]);
                al.add(n-1);
                al.add(n+1);
                for(int i:al){
                    if(i>=0&&i<arr.length&&!vis[i]){
                        q.add(i);
                    }
                }
                al.clear();
            }
            cnt++;
        }
        return 0;
    }
}
