package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeDSurface {
//    private static int[] getFrontView(List<List<Integer>> A) {
//        int[] frontCost = new int[A.size()];
//        for (int i = 0; i < A.size(); i++) {
//            frontCost[i] = A.get(i).get(0);
//        }
//        return frontCost;
//    }

//    private static int[] getCurrentLayer(int col, List<List<Integer>> A) {
//        int[] intermediateLayer = new int[A.size()];
//        for (int r = 0; r < A.get(0).size(); r++) {
//            int prevLayerElement = A.get(r).get(col - 1);
//            int currElement = A.get(r).get(col);
//            int diff = currElement - prevLayerElement;
//            if (diff > 0) {
//                intermediateLayer[r] = diff;
//            } else {
//                intermediateLayer[r] = 0;
//            }
//        }
//        return intermediateLayer;
//    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

//    private static int frontViewCost(List<List<Integer>> A) {
//        int costAns = 0;
//        int[] frontLayer = getFrontView(A);
//        int frontViewSum = getSum(frontLayer);
//        int[] sumOfAllLayers = new int[A.size()];
//        sumOfAllLayers[0] = frontViewSum;
//
//        for (int c = 1; c < A.size(); c++) {
//            int[] currentColLayer = getCurrentLayer(c, A);
//            int currSum = getSum(currentColLayer);
//            sumOfAllLayers[c] = currSum;
//        }
//
//        for (int i = 0; i < A.size(); i++) {
//            costAns += sumOfAllLayers[i]; // Add contributions of all layers
//        }
//        return costAns;
//    }

//    private static int sideViewCostAnd(List<List<Integer>> A) {
//        int costAns = 0;
//
//        int[] allLayerCost = new int[A.size()];
//
//        int[] firstLayer = new int[A.get(0).size()];
//        for (int i = 0; i < A.size(); i++) {
//            firstLayer[i] = A.get(0).get(i);
//        }
//        allLayerCost[0] = getSum(firstLayer);
//
//
//        for (int i = 1; i < A.size(); i++) {
//            int[] currLayer = new int[A.get(0).size()];
//
//            for (int j = 0; j < A.get(i).size(); j++) {
//                int curr = A.get(i).get(j);
//                int prev = A.get(i - 1).get(j);
//                int diff = curr - prev;
//
//                if (diff > 0) {
//                    currLayer[i] = diff;
//                } else {
//                    currLayer[i] = 0;
//                }
//            }
//
//            int getSum = getSum(currLayer);
//            allLayerCost[i] = getSum;
//        }
//
//        for (int i : allLayerCost) {
//            costAns += i;
//        }
//        return costAns;
//    }

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
                } else  {
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
