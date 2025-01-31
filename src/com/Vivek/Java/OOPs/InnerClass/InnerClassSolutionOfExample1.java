package com.Vivek.Java.OOPs.InnerClass;

public class InnerClassSolutionOfExample1 {
    static class Test{ //Making Test class static solvs the problem.
        String name;

        Test(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("A");
    }
}
