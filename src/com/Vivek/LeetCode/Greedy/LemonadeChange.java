package com.Vivek.LeetCode.Greedy;
import java.util.Scanner;

public class LemonadeChange {

//    static boolean changeAvailable(int[] bills, int change, int i){
//        int amount = change;
//        for(int k = i; k >= 0 && amount > 0; k--){
//            if(bills[k] == amount){
////                amount -= bills[i];
//                bills[k] = 0;
//                return true;
//            }else if(bills[k] < amount){
//                amount -=  bills[k];
//                bills[k] = 0;
//            }
//        }
//
//        return amount == 0 ? true : false;
//    }

//    static boolean lemonadeChange(int[] bills){
//        final int eachBuy = 5;
//
//        for(int i = 0; i < bills.length; i++){
//            int remainder = bills[i] - eachBuy;
//            if(remainder == 0){
//                continue;
//            }else{
//                // search for remainder in array i - 1 down to 0
//                boolean flag = changeAvailable(bills, remainder, i - 1);
//                if(!flag){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    static boolean lemonadeChangeSolution(int[] bills){
        int fives = 0;
        int tens = 0;
        int twenty = 0;

        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                fives++;
            }else if(bills[i] == 10){
                fives--;
                tens++;
            }else if(bills[i] == 20){
                if(tens > 0){
                    tens--;
                    fives--;
                    twenty++;
                }else{
                    fives -= 3;
                }
            }
            if(fives < 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        // Test case:
        // [5,5,5,5,20,20,5,5,20,5]
        // [5, 5, 5, 10, 20]: true
        // [5, 5, 10, 10, 20]: false
        // 5 10 20 5: false
        Scanner input = new Scanner(System.in);
        System.out.println("How many customers? ");
        int n = input.nextInt();
        int[] bills = new int[n];
        System.out.println("Enter bill for each customer: ");
        for(int i = 0; i < n; i++){
            bills[i] = input.nextInt();
        }

        System.out.println(lemonadeChangeSolution(bills));
    }
}
