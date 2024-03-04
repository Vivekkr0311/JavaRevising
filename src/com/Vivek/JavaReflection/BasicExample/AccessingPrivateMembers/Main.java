package com.Vivek.JavaReflection.BasicExample.AccessingPrivateMembers;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException{
        Cat myCat = new Cat("Some Name", 10);

        Field[] field = myCat.getClass().getFields();

        for(Field f : field){
            if(f.getName().equals("name")){
                f.setAccessible(true);
                // Below line throws "IllegalAccessException", to prevent this exception
                // we added line f.setAccessible(true);
                f.set(myCat, "New Name");
            }
        }

        // Private field of the class is changed.
        System.out.println(myCat);
    }
}
