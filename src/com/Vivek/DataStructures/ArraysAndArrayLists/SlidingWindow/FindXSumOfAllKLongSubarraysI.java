package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.*;

public class FindXSumOfAllKLongSubarraysI {
    private static TreeMap<Integer, Integer> findFreq(int[] nums, int left, int right){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((a, b) -> b - a);

        for(int i = left; i < right; i++){
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        return treeMap;
    }

    private static int currSubArraySum(int[] nums, int left, int right, int k, int x, TreeMap<Integer, Integer> treeMap){
        int sum = 0;

        // Get the top x most frequent elements from the treeMap
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(treeMap.entrySet());
        sortedEntries.sort((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return e2.getValue() - e1.getValue(); // Compare by frequency (descending)
            }
            return e2.getKey() - e1.getKey(); // Compare by value (descending) if frequencies are equal
        });

        // Sum the frequencies of the top x elements
        for (int i = 0; i < Math.min(x, sortedEntries.size()); i++) {
            Map.Entry<Integer, Integer> entry = sortedEntries.get(i);
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }

    private static int[] findXSum(int[] nums, int k, int x){
      int left = 0;
      int right = left + k;

      int idx = 0;
      int[] ans = new int[nums.length - k + 1];
      while(right <= nums.length){
          TreeMap<Integer, Integer> treeMap = findFreq(nums, left, right);
          ans[idx++] = currSubArraySum(nums, left, right, k, x, treeMap);
          left++;
          right++;
      }

      return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k:");
        int k = scanner.nextInt();

        System.out.println("Enter x: ");
        int x = scanner.nextInt();

        System.out.println("All subarrays: " + Arrays.toString(findXSum(nums, k, x)));
    }
}
