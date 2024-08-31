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

        System.out.println(findSubstring(s, words));
    }
}
