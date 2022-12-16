package com.sprinng.NotificationService.service;

import com.sprinng.NotificationService.config.ProductDto;
import com.sprinng.NotificationService.domain.Notification;

public interface INotificationService {
    public Notification getAllNotifications(String email);
    public void saveNotification(ProductDto productDto);
}
