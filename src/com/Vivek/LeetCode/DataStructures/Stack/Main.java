package com.Vivek.LeetCode.DataStructures.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(46);
        stack.push(8);
        stack.push(3);

        stack.display();

        stack.pop();
        stack.display();

        ArrStack stackArr = new ArrStack(4);
        stackArr.push(5);
        stackArr.push(8);
        stackArr.push(10);
        stackArr.push(98);
        stackArr.display();
    }
}
