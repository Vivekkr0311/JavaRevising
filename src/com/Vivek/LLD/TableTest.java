package com.Vivek.LLD;

import java.util.Scanner;

public class TableTest {
    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void tableTest() {
        Boolean flag;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name of player: ");
            String name = scanner.nextLine();

            System.out.println("Enter the table digit:");
            int n = scanner.nextInt();

            int marks = 0;
            for (int i = 1; i <= 10; i++) {
                System.out.print(n + " * " + i + " = ");
                int ans = scanner.nextInt();

                if (ans != i * n) {
                    System.out.println("Wrong answer, ans is " + i * n + " marks: " + marks);
                } else {
                    marks++;
                }
                System.out.println("marks: " + marks);
            }

            if (marks == 10) {
                System.out.println(name + " is a genius, marks: " + marks);
            } else {
                System.out.println(name + " try again! marks: " + marks);
            }

            System.out.print("Wanna play again ? ");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("yes")) {
                flag = true;
                clearScreen();
            } else {
                flag = false;
            }
        } while (flag);
    }

    public static void main(String[] args) {
        tableTest();
    }
}