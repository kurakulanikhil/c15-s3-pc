package com.sprinng.NotificationService.controller;

import com.sprinng.NotificationService.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3")
public class NotificationController {

    INotificationService notificationService;

    @Autowired
    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notification/{email}")
    public ResponseEntity<?> getNotification(@PathVariable String email){
        return new ResponseEntity<>(notificationService.getAllNotifications(email), HttpStatus.FOUND);
    }
}
