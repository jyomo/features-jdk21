package com.featuresjava21.example;

public abstract class NotificationAbstractFactory {
    protected abstract Notification createNotification(NotificationType type, Request request);
}
