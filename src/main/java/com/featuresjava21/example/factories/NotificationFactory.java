package com.featuresjava21.example.factories;


import com.featuresjava21.example.NotificationAbstractFactory;
import com.featuresjava21.example.NotificationType;
import com.featuresjava21.example.Notification;
import com.featuresjava21.example.Request;
import com.featuresjava21.example.notifications.EmailNotification;
import com.featuresjava21.example.notifications.SMSNotification;

public class NotificationFactory extends NotificationAbstractFactory {
    @Override
    public Notification createNotification(NotificationType type, Request request) {
        return switch (type) {
            case SMS -> new SMSNotification(request.phoneNumber(), request.message());
            case EMAIL -> new EmailNotification(request.emailAddress(), request.message());
            default -> throw new IllegalArgumentException("Invalid notification type");
        };
    }
}
