package com.ds.course.binarytree.solution.practise;

import com.ds.course.binarytree.solution.node.BinaryNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class NBinaryTree {
    public BinaryNode root;

    public NBinaryTree() {
    }


    public void add(int val) {
        if(root == null) {
            root = new BinaryNode();
            root.data = val;
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode temp = queue.remove();
            System.out.print(temp + "\t");
            if(temp.left == null) {
                temp.left = new BinaryNode();
                temp.left.data = val;
                break;
            }
            if(temp.right == null) {
                temp.right = new BinaryNode();
                temp.right.data = val;
                break;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }

    }

    public void deleteNode(int val) {
        if(root == null) {
            System.out.println("Binary Tree is empty");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode temp = null;
        while(!queue.isEmpty()) {
            temp = queue.remove();
            if(temp.data == val) {
                BinaryNode deepestNode = getDeepestNode();
                temp.data = deepestNode.data;
                deleteDeepestNode();
            } else {
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public void deleteDeepestNode() {
        if(root == null) {
            System.out.println("Binary Tree is empty");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null, previousNode = null;
        while(!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if(presentNode.left == null) {
                previousNode.right = null;
                return;
            }
            if(presentNode.right == null) {
                previousNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }
    public BinaryNode getDeepestNode() {
        if(root == null) {
            System.out.println("Binary Tree is empty");
            return null;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode temp = null;
        while(!queue.isEmpty()) {
            temp = queue.remove();
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        return temp;
    }

    public void levelOrderTraversal() {
        if(root == null) {
            System.out.println("Binary Tree is empty");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("\n Traversing Binary Tree \n");
        while(!queue.isEmpty()) {
            BinaryNode temp = queue.remove();
            System.out.print(temp + "\t");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    public void inOrderTraversal(BinaryNode root) {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root +"\t");
        inOrderTraversal(root.right);
    }

    private class BinaryNode {

        public int data;
        public BinaryNode left;
        public BinaryNode right;

        public int height;

        @Override
        public String toString() {
            return "BinaryNode{" +
                    "data=" + data +
                    '}';
        }
    }
}
