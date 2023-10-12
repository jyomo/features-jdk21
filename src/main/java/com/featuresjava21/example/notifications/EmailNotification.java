package com.featuresjava21.example.notifications;

import com.featuresjava21.example.Notification;

public record EmailNotification(String emailAddress, String message) implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Email: " + emailAddress + " - " + message);
    }
}
