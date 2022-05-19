package com.project.Capstone.service;

import com.project.Capstone.dao.NotificationDao;
import com.project.Capstone.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationDao notificationDao;

    @Autowired
    public NotificationService(@Qualifier("notificationDao") NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public String insertNotification(Notification notification){
        return notificationDao.insertNotification(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationDao.selectAllNotifications();
    }

    public Notification getNotificationById(String id) {
        return notificationDao.selectNotificationById(id);
    }

    public int deleteNotification(String id) {
        return notificationDao.deleteNotificationById(id);
    }

}
