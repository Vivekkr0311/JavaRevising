package com.Vivek.DataStructures.Strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class IntegerToRoman {
    private static HashMap<Integer, String> map = new LinkedHashMap<>();
    private static int findFloor(int num){
        int f = 0;

        for(Integer i : map.keySet()){
            if(num == i){
                return i;
            }else if(!(num > i)){
                break;
            }else{
                f = i;
            }
        }
        return f;
    }

    private static String intToRoman(int num) {
        String ans = "";
        while(num != 0){
            int floor = findFloor(num);
            int number_of_times = num / floor;
            for(int i = 1; i <= number_of_times; i++){
                ans = ans + map.get(floor);
            }

            num = num % floor;
        }
        return ans;
    }

    private static void fillMap(){
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer: ");
        int n = scanner.nextInt();

        fillMap();
        System.out.println(n + " in roman is: " + intToRoman(n));
    }
}
