package com.Vivek.DataStructures.Strings;

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
        HashMap<String, Integer> map = getMap(words);

        int wordSize = words[0].length();
        int wordArraySize = words.length;

        List<Integer> ans = new ArrayList<>();
        for(int i = 0;  i <= s.length() - wordSize; i += wordSize){
            HashMap<String, Integer> currMap = new HashMap<>();
            currMap.putAll(map);
            for(int j = i; j < i + wordArraySize * wordSize; j += wordSize){
                String currSubString = s.substring(j, j + wordSize);
                if(!currMap.containsKey(currSubString) || currMap.get(currSubString) == 0){
                    break;
                }else{
                    currMap.put(currSubString, currMap.get(currSubString) - 1);
                }
            }

            boolean allZero = true;
            for(String sub :  currMap.keySet()){
                if(currMap.get(sub) != 0){
                    allZero = false;
                }
            }
            if(allZero){
                ans.add(i);
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
