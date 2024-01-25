package com.Vivek.Greedy;

public class MultiplyingThreeElements {

    // Naive solution
    static int solution(int[] arr){
        int maxProduct = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){

                    int currProd = arr[i] * arr[j] * arr[k];

                    if( currProd > maxProduct){
                        maxProduct = currProd;
                    }
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 10, 7, 5};
        System.out.println(solution(arr));
    }
}
