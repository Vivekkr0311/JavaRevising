package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeDSurface {
    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    private static int sideLeftCost(List<List<Integer>> A) {
        int[] firstlayer = new int[A.get(A.size() - 1).size()];
        for (int i = 0; i < A.size(); i++) {
            firstlayer[i] = A.get(0).get(i);
        }
        int currSum = getSum(firstlayer);
        int[] allLayerCost = new int[A.get(0).size()];
        int idx = 0;
        allLayerCost[idx] = currSum;

        for (int i = 1; i < A.size(); i++) {
            int[] costHelpArray = new int[A.size()];
            for (int j = 0; j < A.size(); j++) {
                int prev = A.get(i - 1).get(j);
                int curr = A.get(i).get(j);

                int diff = curr - prev;
                if (diff > 0) {
                    costHelpArray[j] = diff;
                } else {
                    costHelpArray[j] = 0;
                }
            }

            int currCost = getSum(costHelpArray);
            allLayerCost[++idx] = currCost;
        }
        int totalCost = Arrays.stream(allLayerCost).sum();
        return totalCost;
    }

    private static int sideRightCost(List<List<Integer>> A) {
        int[] firstlayer = new int[A.get(A.size() - 1).size()];
        for (int i = 0; i < A.size(); i++) {
            firstlayer[i] = A.get(A.size() - 1).get(i);
        }

        int currSum = getSum(firstlayer);
        int[] allLayerCost = new int[A.get(0).size()];
        int idx = 0;
        allLayerCost[idx] = currSum;

        for (int i = A.size() - 2; i >= 0; i--) {
            int[] costHelpArray = new int[A.size()];
            for (int j = 0; j < A.size(); j++) {
                int prev = A.get(i + 1).get(j);
                int curr = A.get(i).get(j);

                int diff = curr - prev;
                if (diff > 0) {
                    costHelpArray[j] = diff;
                } else {
                    costHelpArray[j] = 0;
                }
            }

            int currCost = getSum(costHelpArray);
            allLayerCost[++idx] = currCost;
        }
        int totalCost = Arrays.stream(allLayerCost).sum();
        return totalCost;
    }

    private static int sideFrontCost(List<List<Integer>> A) {
        int[] firstlayer = new int[A.get(A.size() - 1).size()];
        for (int i = 0; i < A.size(); i++) {
            firstlayer[i] = A.get(i).get(0);
        }

        int currSum = getSum(firstlayer);
        int[] allLayerCost = new int[A.get(0).size()];
        int idx = 0;
        allLayerCost[idx] = currSum;

        for (int i = 1; i < A.size(); i++) {
            int[] costHelpArray = new int[A.size()];
            for (int j = 0; j < A.size(); j++) {
                int prev = A.get(j).get(i - 1);
                int curr = A.get(j).get(i);

                int diff = curr - prev;
                if (diff > 0) {
                    costHelpArray[j] = diff;
                } else {
                    costHelpArray[j] = 0;
                }
            }

            int currCost = getSum(costHelpArray);
            allLayerCost[++idx] = currCost;
        }
        int totalCost = Arrays.stream(allLayerCost).sum();
        return totalCost;
    }

    private static int sideBackCost(List<List<Integer>> A) {
        int[] firstlayer = new int[A.get(A.size() - 1).size()];
        for (int i = 0; i < A.size(); i++) {
            firstlayer[i] = A.get(i).get(A.size() - 1);
        }

        int currSum = getSum(firstlayer);
        int[] allLayerCost = new int[A.get(0).size()];
        int idx = 0;
        allLayerCost[idx] = currSum;

        for (int c = A.size() - 2; c >= 0; c--) {
            int[] costHelpArray = new int[A.size()];
            for (int r = 0; r < A.size(); r++) {
                int prev = A.get(r).get(c + 1);
                int curr = A.get(r).get(c);

                int diff = curr - prev;
                if (diff > 0) {
                    costHelpArray[r] = diff;
                } else {
                    costHelpArray[r] = 0;
                }
            }

            int currCost = getSum(costHelpArray);
            allLayerCost[++idx] = currCost;
        }
        int totalCost = Arrays.stream(allLayerCost).sum();
        return totalCost;
    }

    public static int surfaceArea(List<List<Integer>> A) {
        int topAndBottomViewCostAns = A.size() * A.get(0).size() * 2;
        int sideLeftCost = sideLeftCost(A);
        int sideRightCost = sideRightCost(A);
        int frontCost = sideFrontCost(A);
        int backCost = sideBackCost(A);

        return topAndBottomViewCostAns + sideLeftCost + sideRightCost + frontCost + backCost;
    }

    private static int surfaceArea2(List<List<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        int totalSurfaceArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int height = A.get(i).get(j);

                // Top and bottom surfaces
                totalSurfaceArea += 2;

                // Left surface or adjacent column difference
                totalSurfaceArea += (j == 0) ? height : Math.max(0, height - A.get(i).get(j - 1));

                // Right surface or adjacent column difference
                totalSurfaceArea += (j == cols - 1) ? height : Math.max(0, height - A.get(i).get(j + 1));

                // Front surface or adjacent row difference
                totalSurfaceArea += (i == 0) ? height : Math.max(0, height - A.get(i - 1).get(j));

                // Back surface or adjacent row difference
                totalSurfaceArea += (i == rows - 1) ? height : Math.max(0, height - A.get(i + 1).get(j));
            }
        }

        return totalSurfaceArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of cols: ");
        int c = scanner.nextInt();
        System.out.println("Enter number of rows: ");
        int r = scanner.nextInt();

        List<List<Integer>> table = new ArrayList<>();

        System.out.println("Enter each row: ");
        for (int i = 0; i < r; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                int temp = scanner.nextInt();
                tempList.add(temp);
            }
            table.add(tempList);
        }

        System.out.println("Table: ");
        for (List<Integer> arr : table) {
            System.out.println(arr);
        }

        int res = surfaceArea(table);
        System.out.println(res);
    }
}
