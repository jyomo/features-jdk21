package com.featuresjava21.example.notifications;

import com.featuresjava21.example.Notification;

public record SMSNotification(String phoneNumber, String message) implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS: " + phoneNumber + " - " + message);
    }
}
