package com.ds.course.binarysearchtree.practise;

import com.ds.course.binarysearchtree.solution.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class NBinarySearchTree {

    private Node root;


    public void insert(int val) {
        root = insert(root, val);
    }


    public Node search(int val) {
        return search(root, val);
    }

    private Node search(Node currentNode, int val) {
        if(currentNode == null) {
            System.out.print("not found");
            return  null;
        }
        if(currentNode.value == val) {
            return currentNode;
        } else if(val < currentNode.value) {
            return search(currentNode.left, val);
        } else {
            return search(currentNode.right, val);
        }
    }

    private Node insert(Node currentNode, int val) {
        if(currentNode == null) {
            currentNode = new Node();
            currentNode.value = val;
        } else if (val <= currentNode.value) {
            currentNode.left = insert(currentNode.left, val);

        } else {
            currentNode.right = insert(currentNode.right, val);
        }
        return currentNode;
    }

    public void traverse() {
        if(root == null)
            System.out.println("Tree is empty");
        Node node = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.value + "\t");
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }

    public void delete(int value) {
        delete(root, value);
    }
    private Node delete(Node currentNode, int value) {
        if(currentNode == null) {
            System.out.println("Node not found");
            return null;
        }
        if( value < currentNode.value) {
            currentNode.left = delete(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = delete(currentNode.right, value);
        } else {
            if(currentNode.left != null && currentNode.right != null) {
                System.out.println("Node to be deleted has 2 children");
                Node successorNode = minimumElement(currentNode.right);
                currentNode.value = successorNode.value;
                currentNode.right = delete(currentNode.right, successorNode.value);
            } else if(currentNode.left != null) {
                System.out.println("Node to be deleted has only left child");
                currentNode = currentNode.left;
            } else if(currentNode.right != null) {
                System.out.println("Node to be deleted has only right child");
                currentNode = currentNode.right;
            } else {
                System.out.println("Node to be deleted has no children");
                currentNode = null;
            }
        }
        return currentNode;
    }

    private Node minimumElement(Node currentNode) {
        if(currentNode.left == null)
            return currentNode;
        else
            return minimumElement(currentNode.left);
    }
    private class Node {
        Integer value;
        Node left;
        Node right;
        int height;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
