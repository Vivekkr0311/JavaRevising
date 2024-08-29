package com.Vivek.DataStructures.Strings;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter digits: ");
        String s = scanner.nextLine();

        System.out.println(letterCombinations(s));
    }
}
