package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradingStudents {
    private static int findNextMultipleOfFive(int mark) {
        int rem = mark % 5;

        if (rem == 0) {
            return mark;
        } else {
            return mark + (5 - rem);
        }
    }

    private static List<Integer> gradingStudents(List<Integer> marks) {
        List<Integer> result = new ArrayList<>();
        for (int mark : marks) {
            if (mark < 38) {
                result.add(mark);
            } else if (mark >= 38) {
                int nextMultiple = findNextMultipleOfFive(mark);

                if (nextMultiple - mark < 3) {
                    result.add(nextMultiple);
                } else {
                    result.add(mark);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();

        List<Integer> marks = new ArrayList<>();
        System.out.println("Enter each score: ");
        for (int i = 0; i < n; i++) {
            marks.add(scanner.nextInt());
        }

        System.out.println("After grading: " + gradingStudents(marks));
    }
}
