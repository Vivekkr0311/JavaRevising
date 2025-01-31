package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.*;

public class SubstringConcatedWithAllWords {

    private static Set<String> allPermut = new HashSet<>();
    private static void allPermuations(List<String> up, String p, int n){
        if(up.isEmpty()){
            allPermut.add(p);
            return;
        }

        String s = up.get(0);
        for(int i = 0; i <= p.length(); i += n){
            String f = p.substring(0, i);
            String sec = p.substring(i);
            String add = f + s + sec;
            allPermuations(up.subList(1, up.size()), add, n);
        }
    }

    private static List<Integer> findSubstring(String s, String[] words){
        int wordSize = words[0].length();
        int wordsArraySize = words.length;
        int totalSize = wordSize * wordsArraySize;
        allPermuations(Arrays.asList(words), "", wordSize);
        List<Integer> ans = new ArrayList<>();
        System.out.println(allPermut);
        for(int i = 0; i <= s.length() - totalSize; i++){
            String sub = s.substring(i, i + totalSize);
            if(allPermut.contains(sub)){
                ans.add(i);
            }
        }
        return ans;
    }

    private static HashMap<String, Integer> getMap(String[] words){
        if(words.length == 0){
            return new HashMap<>();
        }
        HashMap<String, Integer> ans = new HashMap<>();
        for(String s : words){
            if(!ans.containsKey(s)){
                ans.put(s, 1);
            }else{
                ans.put(s, ans.get(s) + 1);
            }
        }
        return ans;
    }

    private static List<Integer> findSubstring2(String s, String[] words){
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int numWords = words.length;
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> windowMap = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (map.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;
                    while (windowMap.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == numWords) {
                        ans.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = scanner.nextLine();
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[n];
        System.out.println("Enter each words: ");
        for(int i = 0; i < n; i++){
            words[i] = scanner.nextLine();
        }

        System.out.println(findSubstring2(s, words));
    }
}
