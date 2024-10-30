package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.*;

public class TheKWeakestRowsInAMatrix {
    private static int[] kWeakestRows(int[][] mat, int k){
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for(int i = 0; i < mat.length; i++){
            int numberOfSoldiers = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    numberOfSoldiers++;
                }
            }

            if(treeMap.get(numberOfSoldiers) != null){
                treeMap.get(numberOfSoldiers).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                treeMap.put(numberOfSoldiers, list);
            }
        }

        System.out.println(treeMap);
        int[] ans = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            for (Integer row : entry.getValue()) {
                if (idx == k) break; // Stop when we've collected k rows
                ans[idx++] = row;
            }
            if (idx == k) break;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int r = scanner.nextInt();
        System.out.println("Enter row size: ");
        int rowSize = scanner.nextInt();
        System.out.println("Insert soldiers 1's and civilians 0's for each row:");
        int[][] mat = new int[r][rowSize];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < rowSize; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        System.out.println("K most weakest rows are: " + Arrays.toString(kWeakestRows(mat, k)));
    }
}
