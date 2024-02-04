package com.ds.course.binarysearchtree.practise;

public class BSTMain {

    public static void main(String[] args) {

        NBinarySearchTree t = new NBinarySearchTree();
        t.insert(100);
        t.insert(140);
        t.insert(70);

        t.insert(60);
        t.insert(80);

        t.insert(50);
        t.insert(65);
        t.insert(49);

        t.insert(75);
        t.insert(85);

        t.insert(130);
        t.insert(150);

        t.insert(135);
        t.insert(125);
        t.insert(120);


        t.traverse();
        System.out.println("\nNode search " + t.search(120));

        t.delete(49);
        t.traverse();
        System.out.println();


        t.delete(125);
        t.traverse();

        System.out.println();
        t.delete(100);

        t.traverse();
    }
}
