package com.ds.course.stack;

public class StackDemo {

    public static void main(String[] args) {
        NStack s = new NStack(6);

        s.traverse();
        s.push(5);
        s.push(10);
        s.push(20);

        s.traverse();
        s.pop();
        s.traverse();

        s.push(15);
        s.push(20);
        s.push(25);
        s.traverse();

        s.push(30);
        s.push(35);

        for(int i=0; i < 7; i++) {
            System.out.println(s.pop());
        }
    }
}
