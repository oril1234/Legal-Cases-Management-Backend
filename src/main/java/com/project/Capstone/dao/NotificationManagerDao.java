package com.project.Capstone.dao;

import com.project.Capstone.model.Notification;
import com.project.Capstone.model.NotificationManager;

import java.util.List;

public interface NotificationManagerDao {

    int insertNotificationManager(NotificationManager notificationManager);

    List<Notification> selectNotificationsForPersonId(int personId);

    List<Notification> selectAllNotificationsFromNotificationManager();

    List<NotificationManager> selectAllNotificationManagers();

    int deleteNotificationManagerById(String id);

    int deleteNotificationManagerByNotificationIdAndReceiverId(String id, int receiverId);

    int updateNotificationsOfPersonToRead(int receiverId);

    int numberOfUnreadNotificationPerPerson(int receiverId);
}
