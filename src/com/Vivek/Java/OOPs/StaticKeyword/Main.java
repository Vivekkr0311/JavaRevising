package com.Vivek.Java.OOPs.StaticKeyword;

public class Main {
    public static void main(String[] args) {
        Human Kiara = new Human();
        Kiara.setName("Kiara");
        Kiara.setAge(26);
        System.out.println(Human.getPopulation());

        Human Vivek = new Human("Vivek", 26);

        System.out.println(Human.getPopulation());

        Human temp = new Human();
        for(int i = 0; i < 10000000; i++){
            temp = new Human();
        }
    }
}
