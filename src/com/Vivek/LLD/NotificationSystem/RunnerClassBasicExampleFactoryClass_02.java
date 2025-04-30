package com.Vivek.LLD.NotificationSystem;

import com.Vivek.LLD.NotificationSystem.factory.NotificationFactory;
import com.Vivek.LLD.NotificationSystem.service.NotificationService;

//                           +-------------------+
//                           | <<Interface>>     |
//                           | Notification      |
//                           |------------------ |
//                           | +send(message)    |
//                           +---------+----------+
//                                     |
//                 ---------------------------------------
//                 |                   |                 |
//        +----------------+  +----------------+ +----------------+
//        |EmailNotification| |SMSNotification | |PushNotification|
//        |-----------------| |----------------| |----------------|
//        |+send(message)   | |+send(message)  | |+send(message)  |
//        +-----------------+ +----------------+ +----------------+
//
//        +---------------------------------------+
//        |      NotificationFactory              |
//        |---------------------------------------|
//        |+createNotification(type):Notification |
//        +---------------------------------------+
//
//        +----------------------------+
//        |    NotificationService     |
//        |----------------------------|
//        |-notification: Notification |
//        |+notifyUser(message): void  |
//        +----------------------------+
//
//        +----------------------------+
//        |      Main                  |
//        |----------------------------|
//        | (creates notification)     |
//        | (uses NotificationService) |
//        +----------------------------+
//


public class RunnerClassBasicExampleFactoryClass_02 {

    public static void main(String[] args) throws IllegalAccessException {
        Notification emailNotification = NotificationFactory.createNotification("email");
        Notification smsNotification = NotificationFactory.createNotification("sms");
        Notification pushNotification = NotificationFactory.createNotification("push");

        NotificationService notificationService = new NotificationService(emailNotification);
        notificationService.notifyUser("Welcome to Factory Pattern!");

        NotificationService notificationService2 = new NotificationService(smsNotification);
        notificationService2.notifyUser("Welcome to Factory Pattern!");

        NotificationService notificationService3 = new NotificationService(pushNotification);
        notificationService3.notifyUser("Welcome to Factory Pattern!");
    }
}