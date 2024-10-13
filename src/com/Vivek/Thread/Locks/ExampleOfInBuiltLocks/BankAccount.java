package com.Vivek.Thread.Locks.ExampleOfInBuiltLocks;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Transaction initiating");
        try{
            if(amount <= balance){
                System.out.println(Thread.currentThread().getName() + " Withdrawal initiated");
                Thread.sleep(10000);
                this.balance -= amount;
                System.out.println(Thread.currentThread().getName() + " Transaction completed" + " balance is " + this.balance);
            }else{
                System.out.println(Thread.currentThread().getName() + " Insufficient balance: " + this.balance);
            }
        }catch (Exception e){

        }
    }
}
