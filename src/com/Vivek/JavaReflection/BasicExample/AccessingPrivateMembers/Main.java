package com.Vivek.JavaReflection.BasicExample.AccessingPrivateMembers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat myCat = new Cat("Some Name", 10);

        Field[] field = myCat.getClass().getFields();

        for (Field f : field) {
            if (f.getName().equals("name")) {
                f.setAccessible(true);
                // Below line throws "IllegalAccessException", to prevent this exception
                // we added line f.setAccessible(true);
                f.set(myCat, "New Name");
            }
        }

        // Private field of the class is changed.
        System.out.println(myCat);

        Method[] methods = myCat.getClass().getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().equals("privateMethod")){
                m.setAccessible(true);
                // This throw "IllegalAccessException".
                m.invoke(myCat);
            }
        }
    }
}
