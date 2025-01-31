package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.*;

public class IntersectionOfTwoArrays {

    private static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -(start + 1);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        int idxAns = 0;
        for(int i = 0; i < nums1.length; i++){
            int idx = search(nums2, nums1[i]);

            if(idx >= 0){
                set.add(nums1[i]);
            }
        }

        int[] ans = new int[set.size()];
        for(int num : set){
            ans[idxAns++] = num;
        }
        return ans;
    }

    private static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] != nums2[j]){
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            } else if(nums1[i] == nums2[j]){
                list.add(nums1[i]);

                while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]){
                    i++;
                }

                while(j + 1 < nums2.length && nums2[j] == nums2[j + 1]){
                    j++;
                }
                i++;
                j++;
            }
        }


        int[] ans = new int[list.size()];
        int idx = 0;
        for(int num : list){
            ans[idx++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements? arr1: ");
        int n1 = scanner.nextInt();

        int[] arr1 = new int[n1];
        System.out.print("Insert each elements: arr1 ");
        for(int i = 0; i < n1; i++){
            arr1[i] = scanner.nextInt();
        }

        System.out.println("How many elements? arr12 ");
        int n2 = scanner.nextInt();

        int[] arr2 = new int[n2];
        System.out.print("Insert each elements: arr2 ");
        for(int i = 0; i < n2; i++){
            arr2[i] = scanner.nextInt();
        }

//        System.out.println(Arrays.toString(intersection(arr1, arr2)));
        System.out.println(Arrays.toString(intersection2(arr1, arr2)));
    }
}
