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

    private static int countNumberOfOnesUsingBinarySearch(int[] row){
        int start = 0;
        int end = row.length - 1;

        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(row[mid] == 1){
                start = mid + 1;
            }else if(row[mid] == 0){
                end = mid - 1;
            }
        }

        return end + 1;
    }

    private static int[] kWeakestRowsTwo(int[][] mat, int k){
        int[][] soldiersCount = new int[mat.length][2];

        for(int i = 0; i < mat.length; i++){
            int numberOfSoldiers = countNumberOfOnesUsingBinarySearch(mat[i]);
            soldiersCount[i][0] = numberOfSoldiers;
            soldiersCount[i][1] = i;
        }

        Arrays.sort(soldiersCount, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }else{
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = soldiersCount[i][1];
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
        System.out.println("K most weakest rows are: " + Arrays.toString(kWeakestRowsTwo(mat, k)));
    }
}
