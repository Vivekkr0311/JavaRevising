package com.Vivek.PasswordGen;

public class PassGenAlpha {
    static void passGenAlpha(){
        char[] alpha = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',

                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        for(int i = 0; i < alpha.length; i++){
            for(int j = 0; j < alpha.length; j++){
                for(int k = 0; k < alpha.length; k++){
                    for(int l = 0; l < alpha.length; l++){
                        String pass = "" + alpha[i] + alpha[j] + alpha[k] + alpha[k];
                        System.out.println("Password: " + pass);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        passGenAlpha();
    }
}
