package com.Vivek.LeetCode.ConditionsAndLoop;

import java.util.Scanner;

public class WorkingWithSwitch {
    public static void main(String[] args) {
        // "==" operator checks for the reference, if reference variable "a" and another reference variable "b" is pointing
        // to the same object or not. Like this if(a == b). It will return true if both "a" and "b" refers to the same object
        // otherwise it will return false.
        //That is why, to compare strings we will use ".equals()" method to compare if two strings are same (content wise).

        Scanner in  = new Scanner(System.in);
//        System.out.print("[?] Insert two strings: ");
//        String a = in.nextLine();
//        String b = in.nextLine();
//
//        System.out.println("[+] '==' returns " + equalsOperator(a, b) + " because objects are different.");
//        System.out.println("[+] '.equals()' method returns " + dotEqualsMethod(a, b) + " because content is same.");
//
//        System.out.println("After assigning 'b' to 'a', now 'a' and 'b' refers to same object so, ");
//        a = b;
//        System.out.println("[+] '==' returns " + equalsOperator(a, b));

        System.out.print("[?] Hi, insert your fav fruit name: ");
        String yourFavFruit = in.nextLine();
        switchStatementDemo(yourFavFruit);

        enhancedSwitchStatementDemo(yourFavFruit);

        moreOnSwitch();

        Scanner input = new Scanner(System.in);
        System.out.print("[?] Insert department ID: ");
        int id = input.nextInt();
        System.out.print("[?] Insert person name: ");
        String name = input.next();
        nestedSwitchStatement(id, name.charAt(0));
    }
    
    static boolean equalsOperator(String a, String b){
        return a == b;
    }
    
    static boolean dotEqualsMethod(String a, String b){
        return a.equals(b);
    }

    static void switchStatementDemo(String fruitName){

        boolean fruitFound;
        switch (fruitName){
            case "Mango":
                fruitFound = true;
                break;
            case "Apple":
                fruitFound = true;
                break;
            case "Guava":
                fruitFound = true;
                break;
            case "Grapes":
                fruitFound = true;
                break;
            default:
                fruitFound = false;
                break;
        }

        if(fruitFound){
            System.out.println("[+] Yay! We have " + fruitName + " in our store.");
        }else{
            System.out.println("[-] Sorry, We don't have " +  fruitName + " in our store.");
        }
    }

    static void enhancedSwitchStatementDemo(String fruitName){
        System.out.println("[!] Enhanced switch statement is executing. ");
        boolean fruitFound;
        switch (fruitName){
            case "Mango" -> fruitFound = true;
            case "Apple" -> fruitFound = true;
            case "Guava" -> fruitFound = true;
            case "Grapes" -> fruitFound = true;
            default -> fruitFound = false;
        }

        if(fruitFound)
            System.out.println("[+] Yay! We have " + fruitName + " in our store.");
        else
            System.out.println("[-] Sorry, We don't have " +  fruitName + " in our store.");
    }

    static void moreOnSwitch(){
        Scanner input = new Scanner(System.in);
        System.out.print("[?] Give a number which is even or odd in range [1, 10]: ");
        int number  = input.nextInt();

        switch (number){
            case 2, 4, 6, 8, 10 -> System.out.println("[+] You inserted even number.");
            case 1, 3, 5, 7, 9 -> System.out.println("[+] You inserted odd number.");
            default -> System.out.println("[-] Please insert a number with in [1, 10].");
        }
    }

    static void nestedSwitchStatement(int id, char name){
        System.out.println();
        switch (id){
            case 1:
                switch (name){
                    case 'A':
                        System.out.println("[+] Yes, 'A' works in department '1'.");
                        break;
                    case 'B':
                        System.out.println("[+] Yes, 'B' works in department '1'.");
                        break;
                    default:
                        System.out.println("[-] There is not such records.");
                }
                break;
            case 2:
                switch (name){
                    case 'C':
                        System.out.println("[+] Yes, 'A' works in department '1'.");
                        break;
                    case 'D':
                        System.out.println("[+] Yes, 'B' works in department '1'.");
                        break;
                    default:
                        System.out.println("[-] There is not such records.");
                }
                break;

            default:
                System.out.println("[-] There is no such department.");
        }
    }
}
