package com.Vivek.LLD.NotificationSystem;

import com.Vivek.LLD.NotificationSystem.service.NotificationService;
import com.Vivek.LLD.NotificationSystem.entities.EmailNotification;
import com.Vivek.LLD.NotificationSystem.entities.SMSNotification;
import com.Vivek.LLD.NotificationSystem.entities.PushNotification;

public class RunnerClassBasicExample_01 {

    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();
        Notification pushNotification = new PushNotification();

        NotificationService notificationService = new NotificationService(emailNotification);
        notificationService.notifyUser("this is email");

        NotificationService notificationService2 = new NotificationService(smsNotification);
        notificationService2.notifyUser("this is sms");

        NotificationService notificationService3 = new NotificationService(pushNotification);
        notificationService3.notifyUser("this is push");
    }
}
