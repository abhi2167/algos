package com.ds.leetcode.Arrays.twopointers;

public class NextGreaterElement3 {

    public static void main(String[] args) {
        NextGreaterElement3 o = new NextGreaterElement3();
        int n = 1476531;
        System.out.println("Next greater permutation = " + o.nextGreaterElement(n));
    }

    public int nextGreaterElement(int n) {
        int ans = -1;
        char[] a = (""+n).toCharArray();
        int i = a.length-2;
        while(i >=0 && a[i+1] <= a[i]) {
            i--;
        }

        if(i >= 0) {
            int j = a.length-1;
            while(j >= 0 && a[i] >= a[j]) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i+1);
        try {
            ans = Integer.parseInt(new String(a));
        } catch (Exception e) {
            ans = -1;
        }
        return ans;
    }

    private void reverse(char[] a, int i) {
        int left = i;
        int right = a.length-1;
        while(left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
