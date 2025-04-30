package com.Vivek.LLD.NotificationSystem.factory;

import com.Vivek.LLD.NotificationSystem.Notification;
import com.Vivek.LLD.NotificationSystem.entities.EmailNotification;
import com.Vivek.LLD.NotificationSystem.entities.PushNotification;
import com.Vivek.LLD.NotificationSystem.entities.SMSNotification;

public class NotificationFactory {
    public final static Notification createNotification(String type) throws IllegalAccessException {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("push")) {
            return new PushNotification();
        }

        throw new IllegalAccessException("Notification type is not valid");
    }
}
