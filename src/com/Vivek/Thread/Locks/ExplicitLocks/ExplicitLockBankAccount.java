package com.Vivek.Thread.Locks.ExplicitLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLockBankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Transaction initiating");
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(amount <= balance){

                    try{
                        System.out.println(Thread.currentThread().getName() + " Withdrawal initiated");
                        Thread.sleep(10000);
                        this.balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Transaction completed" + " balance is " + this.balance);
                    }catch (Exception r){
                        // This is used to retain the state of the thread if it was interrupted.
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }

                }else{
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance" + this.balance);
                }
            } else{
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock, try again later!");
            }
        }catch (Exception e){
            // This is used to retain the state of the thread if it was interrupted.
            Thread.currentThread().interrupt();
        }
    }
}
