package com.Vivek.LLD.NotificationSystem.config;

import com.Vivek.LLD.NotificationSystem.Notification;
import com.Vivek.LLD.NotificationSystem.factory.NotificationFactory;
import com.Vivek.LLD.NotificationSystem.service.NotificationService;

public class AppConfig {
    public NotificationService notificationService(String type) throws IllegalAccessException {
        Notification notification = NotificationFactory.createNotification(type);
        return new NotificationService(notification);
    }
}