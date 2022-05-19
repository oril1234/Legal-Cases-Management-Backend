package com.project.Capstone.dao;

import com.project.Capstone.model.Notification;

import java.util.List;

public interface NotificationDao {

    String insertNotification(Notification notification);

    List<Notification> selectAllNotifications();

    Notification selectNotificationById(String id);

    int deleteNotificationById(String id);
}
