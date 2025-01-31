package com.Vivek.Java.JavaSteeamAPIs.Introduction_To_Java_Lambda_Function;

class Task implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello!");
    }
}

public class Introduction_LambdaFunctions {
    public static void main(String[] args) {
//       Lambda function has:
//            - Has no function name
//            - Has no function return type
//            - Has no function access specifier

//        Normal function                               // Lambda functions
//        @Override
//        public void run(){                      =>      () -> {
//            System.out.println("Hello!");                  System.out.println("Hello!);
//        }                                               }

        Thread t1 = new Thread(
                // This lambda function is created so that we don't need to create a class like Task
                // to override run() method
                () -> {
                    System.out.println("Hello from lambda function!!");
                }
        );
    }
}
