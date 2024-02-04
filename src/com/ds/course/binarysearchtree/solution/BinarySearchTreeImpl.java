package com.ds.course.binarysearchtree.solution;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl {
    public BinaryNode root;

    public BinarySearchTreeImpl() {

    }

    public void add(int val) {
        add(root, val);
    }

    public BinaryNode add(BinaryNode root, int val) {
        if(root == null) {
            root = new BinaryNode();
            root.setValue(val);
            return root;
        }
        if(val <= root.getValue()) {
            root.setLeft(add(root.getLeft(), val));
            return root;
        } else {
            root.setRight(add(root.getRight(), val));
            return root;
        }
    }

    public BinaryNode delete(BinaryNode currentNode , int val) {
        if(currentNode == null) {
            // node not found
            return null;
        }
        if(currentNode.getValue() == val) {
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {
                currentNode = null;
            } else if(currentNode.getLeft() == null) {
                currentNode = currentNode.getRight();
            } else if(currentNode.getRight() == null) {
                currentNode = currentNode.getLeft();
            } else {
                BinaryNode successorNode = findSuccessorNode(currentNode.getRight());
                currentNode.setValue(successorNode.getValue());
                currentNode.setRight(delete(currentNode.getRight(), successorNode.getValue()));
            }
        } else if (val < currentNode.getValue()) {
            currentNode.setLeft(delete(currentNode.getLeft(), val));
        } else {
            currentNode.setRight(delete(currentNode.getRight(), val));
        }
        return currentNode;
    }

    public BinaryNode findSuccessorNode(BinaryNode currentNode) {
        return currentNode.getLeft() != null ? findSuccessorNode(currentNode.getLeft()) : currentNode;
    }
}
