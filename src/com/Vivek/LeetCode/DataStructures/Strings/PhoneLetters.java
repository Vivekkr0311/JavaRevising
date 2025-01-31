package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.*;

public class PhoneLetters {

    private static char[] two = {'a', 'b', 'c'};
    private static char[] three = {'d', 'e', 'f'};
    private static char[] four = {'g', 'h', 'i'};
    private static char[] five = {'j', 'k', 'l'};
    private static char[] six = {'m', 'n', 'o'};
    private static char[] seven = {'p', 'q', 'r', 's'};
    private static char[] eight = {'t', 'u', 'v'};
    private static char[] nine = {'w', 'x', 'y', 'z'};

    private static HashMap<Character, char[]> map = new HashMap<>();

    private static List<String> helper(String digits){
        char[] digits_char = digits.toCharArray();

        List<String> global_ans = new LinkedList<>();

        if(digits_char.length == 1){
             char[] ans = map.get(digits_char[0]);
             for(char ch : ans){
                 global_ans.add(ch + "");
             }
             return global_ans;
        }

        char[] ans = map.get(digits_char[0]);
        for(char ch :  ans){
            global_ans.add(ch + "");
        }

        for(int i = 1; i < digits.length(); i++){
            char[] s = map.get(digits_char[i]);

            List<String> imd = new ArrayList<>();
            for(int j = 0; j < global_ans.size(); j++){
                for(int k = 0; k < s.length; k++){
                    imd.add(global_ans.get(j) + s[k]);
                }
            }

            global_ans.addAll(imd);
        }

        List<String> res = new ArrayList<>();
        for(String s : global_ans){
            if(s.length() == digits.length()){
                res.add(s);
            }
        }
        return res;
    }

    private static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        map.put('2', two);
        map.put('3', three);
        map.put('4', four);
        map.put('5', five);
        map.put('6', six);
        map.put('7', seven);
        map.put('8', eight);
        map.put('9', nine);

        List<String> result = helper(digits);
        return result;
    }

    private static List<String> helper2(String up, String p){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char[] characters = map.get(up.charAt(0));

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < characters.length; i++){
            List<String> callList = helper2(up.substring(1), p + characters[i]);
            ans.addAll(callList);
        }
        return ans;
    }

    private static List<String> letterCombinations2(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        map.put('2', two);
        map.put('3', three);
        map.put('4', four);
        map.put('5', five);
        map.put('6', six);
        map.put('7', seven);
        map.put('8', eight);
        map.put('9', nine);

        return helper2(digits, "");
    }


    private static List<String> helper3(String up, String p){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        int lower_bound = (digit - 2) * 3;
        int higher_bound = (digit - 1) * 3;
        if(digit == 7){
            higher_bound = higher_bound + 1;
        }else if(digit == 9){
            lower_bound = lower_bound + 1;
            higher_bound = higher_bound + 2;
        }else if(digit == 8){
            lower_bound += 1;
            higher_bound += 1;
        }
        List<String> ans = new ArrayList<>();
        for(int i = lower_bound; i < higher_bound; i++){
            char ch = (char) ('a' + i);
            List<String> list = helper3(up.substring(1), p + ch);
            ans.addAll(list);
        }
        return ans;
    }

    private static List<String> letterCombinations3(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }

        return helper3(digits, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter digits: ");
        String s = scanner.nextLine();

//        System.out.println(letterCombinations(s));
//        System.out.println(letterCombinations2(s));
        System.out.println(letterCombinations3(s));
    }
}
