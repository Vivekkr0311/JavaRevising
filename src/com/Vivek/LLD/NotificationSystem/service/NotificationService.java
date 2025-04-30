package com.Vivek.LLD.NotificationSystem.service;

import com.Vivek.LLD.NotificationSystem.Notification;

public class NotificationService {
    private final Notification notificationStrategy;

    public NotificationService(Notification notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void notifyUser(String message) {
        if (notificationStrategy == null) {
            throw new IllegalStateException("Notification strategy not set.");
        }
        this.notificationStrategy.send(message);
    }
}
