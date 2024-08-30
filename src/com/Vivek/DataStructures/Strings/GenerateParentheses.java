package com.Vivek.DataStructures.Strings;

import java.util.*;

public class GenerateParentheses {

    private static Set<String> ansSet = new HashSet<>();
    private static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private static List<String> allPermu = new ArrayList<>();
    private static void allPermutations(String up, String p){
        if(up.isEmpty()){
            allPermu.add(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i);
            String a = f + ch + s;
            allPermutations(up.substring(1), a);
        }
    }

    private static List<String> generateParenthesis(int n){
        String input = "";
        for(int i = 0; i < n; i++){
            input = input + "()";
        }
        allPermutations(input, "");
        for(String s : allPermu){
            if(isBalanced(s) && !ansSet.contains(s)){
                ansSet.add(s);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String s : ansSet){
            ans.add(s);
        }
        return ans;
    }

    private static List<String> res = new ArrayList<>();
    private static void helper2(StringBuilder sb, int openN, int closeN, int n){
        if(openN == n && closeN == n){
            res.add(sb.toString());
            return;
        }

        if(openN < n){
            sb.append("(");
            helper2(sb, openN + 1, closeN, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeN < openN){
            sb.append(")");
            helper2(sb, openN, closeN + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static List<String> generateParenthesis2(int n) {
        res.clear();
        helper2(new StringBuilder(), 0, 0, n);
        return res;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        List<String> ans = generateParenthesis2(n);
//        System.out.println(allPermu);
        System.out.println(ans);
    }
}
