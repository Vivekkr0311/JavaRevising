package com.Vivek.LLD.NotificationSystem.entities;

import com.Vivek.LLD.NotificationSystem.Notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending " + message + " using SMS.");
    }
}
