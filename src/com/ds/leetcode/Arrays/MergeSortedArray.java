package com.ds.leetcode.Arrays;

import java.util.Arrays;

public class MergeSortedArray {
    // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int m = 3;
        MergeSortedArray s  = new MergeSortedArray();
        s.merge_mergeSort(nums1, m, nums2, nums2.length);

        int [] nums3 = {1,2,3,0,0,0};
        int [] nums4 = {2,5,6};
        int m1 = 3;
        s.merge(nums3, m1, nums4, nums4.length);


        int [] nums5 = {1,2,4,5,6,0};
        int [] nums6 = {3};
        int m2 = 5;
        //s.merge_quick(nums5, m2, nums6, nums6.length);


        int [] nums7 = {1,2,4,5,6,0,0,0};
        int [] nums8 = {3,7,8};
        int m3 = 5;
        s.merge_3pointers(nums7, m3, nums8, nums8.length);
    }

    public void merge_3pointers(int[] nums1, int m, int[] nums2, int n) {
        int nums1Copy [] = Arrays.copyOf(nums1, m);
        System.out.println("nums1 " + Arrays.toString(nums1Copy));
        int p1=0, p2=0, i=0;
        while(p1 < m && p2 < n && i < nums1.length) {
            if(nums1Copy[p1] <= nums2[p2]) {
                nums1[i] = nums1Copy[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        while(p1 < m && i < nums1.length) {
            nums1[i] = nums1Copy[p1];
            p1++;
            i++;
        }
        while(p2 < n && i < nums1.length) {
            nums1[i] = nums2[p2];
            p2++;
            i++;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public void merge_quick(int[] nums1, int m, int[] nums2, int n) {
        int p= m+n-1;
        int p1=m-1;
        int p2 = n-1;
        while(p >= 0) {
            if(p2 < 0) {
                break;
            }
            if(p1 >=0 && nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while(i < nums1.length && j < n) {
            if(i < m && nums1[i] <= nums2[j]) {
                i++;
            } else {
                for(int x=nums1.length-1; x > i ;x--) {
                    nums1[x] = nums1[x-1];
                }
                nums1[i] = nums2[j];
                j++;
                i++;
                m++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public void merge_mergeSort(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i < result.length) {
            while(j < m && k < n) {
                if(nums1[j] <= nums2[k]) {
                    result[i] = nums1[j];
                    j++;
                }  else {
                    result[i] = nums2[k];
                    k++;
                }
                i++;
            }
            while(j < m) {
                result[i] = nums1[j];
                j++;
                i++;
            }
            while(k < n) {
                result[i] = nums2[k];
                k++;
                i++;
            }
        }
        for(int x=0; x < result.length;x++) {
            nums1[x] = result[x];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
