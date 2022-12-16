package com.sprinng.NotificationService.service;

import com.sprinng.NotificationService.config.ProductDto;
import com.sprinng.NotificationService.domain.Notification;
import com.sprinng.NotificationService.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService{

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public Notification getAllNotifications(String email) {
       return notificationRepository.findById(email).get();
    }

    @RabbitListener(queues = "product-queue")
    @Override
    public void saveNotification(ProductDto productDto) {
        Notification notification = new Notification();
        String email = productDto.getJsonObject().get("email").toString();
        if(notificationRepository.findById(email).isEmpty()){
            notification.setEmail(email);
        }
        notification.setNotificationMessage("The list not matched products");
        notification.setProduct(productDto.getJsonObject());
        notificationRepository.save(notification);

    }
}
