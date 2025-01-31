package com.Vivek.LeetCode.PasswordGen;

public class PassGen {
    static void passGen(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 10; l++){
                        System.out.println("Password: " + i + "" + j + "" + k + "" +l);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        passGen();
    }
}
