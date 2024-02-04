package com.ds.course.binarytree.solution.practise;

public class BinaryTreeMain {

    public static void main(String[] args) {
        NBinaryTree bt = new NBinaryTree();
        bt.add(5);
        bt.add(10);
        bt.add(20);


        bt.add(15);
        bt.add(50);

        bt.add(100);
        bt.add(200);
        bt.add(150);
        bt.levelOrderTraversal();
        System.out.println(" \n InOrder Traversal ");
        bt.inOrderTraversal(bt.root);

        System.out.println("\nDeepest Node: " + bt.getDeepestNode());
        bt.deleteNode(5);
        bt.levelOrderTraversal();

    }
}
