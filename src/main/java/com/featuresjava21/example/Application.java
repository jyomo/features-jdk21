package com.featuresjava21.example;

import com.featuresjava21.example.factories.NotificationFactory;

import static java.lang.StringTemplate.STR;

public class Application {
    public static void main(String[] args) {

        NotificationFactory factory = new NotificationFactory();
        var number = "+511234567890";
        var message = STR. """
        <html>
          <head>
            <title>Title</title>
          </head>
          <body>
            <p>Este es una prueba, puedes contactarme al \{ number }</p>
          </body>
        </html>
        """ ;
        Request request = new Request(number, "user@ejemplo.com", message);
        Notification notification = factory.createNotification(NotificationType.EMAIL, request);
        notification.send();
    }
}


