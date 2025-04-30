package com.Vivek.LLD.NotificationSystem;

import com.Vivek.LLD.NotificationSystem.config.AppConfig;
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
//                                    |
//                                    |
//                                    |  (uses to return instance of Email, SMS, or Push Notification
//                                    v
//
//                  +---------------------------------------+
//                  |      NotificationFactory              |
//                  |---------------------------------------|
//                  |+createNotification(type):Notification |
//                  +---------------------------------------+
//
//        +----------------------------+
//        |    NotificationService     |
//        |----------------------------|
//        |-notification: Notification |
//        |+notifyUser(message): void  |
//        +----------------------------+
//                        |  (used in AppConfig class)
//                        v
//        +--------------------------------------------+
//        |         AppConfig                          |
//        |--------------------------------------------|
//        |+notificationService(): NotificationService |
//        +--------------------------------------------+
//                        |  (used in main class to config the app)
//                        v
//        +----------------------------------+
//        |      Main                        |
//        |----------------------------------|
//        | (gets service from AppConfig)    |
//        | (uses NotificationService)       |
//        +----------------------------------+
//


public class RunnerClassBasicExampleDependencyInversion_03 {

    public static void main(String[] args) throws IllegalAccessException {
        AppConfig appConfig = new AppConfig();
        NotificationService emailNotificationService = appConfig.notificationService("email");
        emailNotificationService.notifyUser("DI is awesome!");

        NotificationService smsNotificationService = appConfig.notificationService("sms");
        smsNotificationService.notifyUser("DI is awesome!");

        NotificationService pushNotificationService = appConfig.notificationService("push");
        pushNotificationService.notifyUser("DI is awesome!");
    }
}