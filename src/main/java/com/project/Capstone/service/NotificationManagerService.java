package com.project.Capstone.service;

import com.project.Capstone.dao.NotificationManagerDao;
import com.project.Capstone.model.Notification;
import com.project.Capstone.model.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManagerService {

    private final NotificationManagerDao notificationManagerDao;

    @Autowired
    public NotificationManagerService(@Qualifier("notificationManagerDao") NotificationManagerDao notificationManagerDao) {
        this.notificationManagerDao = notificationManagerDao;
    }

    public int insertNotificationManager(NotificationManager notificationManager) {
        return notificationManagerDao.insertNotificationManager(notificationManager);
    }

    public List<Notification> selectNotificationsForPersonId(int personId) {
        return notificationManagerDao.selectNotificationsForPersonId(personId);
    }

    public List<Notification> selectAllNotificationsFromNotificationManager() {
        return notificationManagerDao.selectAllNotificationsFromNotificationManager();
    }

    public List<NotificationManager> selectAllNotificationManagers() {
        return notificationManagerDao.selectAllNotificationManagers();
    }

    public int deleteNotificationManagerById(String id) {
        return notificationManagerDao.deleteNotificationManagerById(id);
    }

    public int deleteNotificationManagerByNotificationIdAndReceiverId(String id, int receiverId) {
        return notificationManagerDao.deleteNotificationManagerByNotificationIdAndReceiverId(id, receiverId);
    }

    public int updateNotificationsOfPersonToRead(int id) {
        return notificationManagerDao.updateNotificationsOfPersonToRead(id);
    }

    public int numberOfUnreadNotificationPerPerson(int receiverId) {
        return notificationManagerDao.numberOfUnreadNotificationPerPerson(receiverId);
    }

}
