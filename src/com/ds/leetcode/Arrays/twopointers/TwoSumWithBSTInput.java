package com.ds.leetcode.Arrays.twopointers;

import java.util.*;

public class TwoSumWithBSTInput {

    public static void main(String[] args) {
        TwoSumWithBSTInput o = new TwoSumWithBSTInput();
    }

    public boolean findTarget_usingrecursion(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> treeNodeValues = new ArrayList<>();
        inorderBSTTraversal(root, treeNodeValues);
        int left = 0;
        int right = treeNodeValues.size()-1;
        int currentSum = 0;
        while(left < right) {
            currentSum = treeNodeValues.get(left) + treeNodeValues.get(right);
            if(currentSum == k) {
                return true;
            } else if(currentSum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorderBSTTraversal(TreeNode root, List<Integer> treeNodeValues) {
        if(root == null) {
            return;
        }
        inorderBSTTraversal(root.left, treeNodeValues);
        treeNodeValues.add(root.val);
        inorderBSTTraversal(root.right, treeNodeValues);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while(!queue.isEmpty()) {
            if(queue.peek() != null) {
                node = queue.remove();
                if(seen.contains(k - node.val)) {
                    return true;
                }
                seen.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                queue.remove();
            }
        }
        return false;
    }


    private boolean findTarget_usingrecursion(TreeNode root, int k, Set<Integer> seen) {
        if(root == null) {
            return false;
        }
        if(seen.contains(k - root.val)) {
            return true;
        }
        seen.add(root.val);
        return findTarget_usingrecursion(root.left, k, seen) || findTarget_usingrecursion(root.right, k, seen);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}