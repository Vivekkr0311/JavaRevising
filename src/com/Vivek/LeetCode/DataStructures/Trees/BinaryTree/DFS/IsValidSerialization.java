package com.Vivek.LeetCode.DataStructures.Trees.BinaryTree.DFS;

public class IsValidSerialization {

    private static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int vaccancy = 1;

        for(int i = 0; i < nodes.length; i++){
            vaccancy--;

            if(vaccancy < 0){
                return false;
            }

            if(!nodes[i].equals("#")){
                vaccancy += 2;
            }
        }
        return vaccancy == 0;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "9,3,4,#,#,1,#,#,2,#,6,#,#",
                "1,#",
                "9,#,#,1"
        };

        for(String ip : inputs){
            System.out.println(ip + " is a valid serialization: " + isValidSerialization(ip));
        }
    }
}
