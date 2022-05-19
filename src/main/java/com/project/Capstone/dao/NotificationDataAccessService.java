package com.project.Capstone.dao;

import com.project.Capstone.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("notificationDao")
public class NotificationDataAccessService implements NotificationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String notificationsTableName = "NOTIFICATIONS";

    @Override
    public String insertNotification(Notification notification) {
        String generatedUUID = String.valueOf(UUID.randomUUID());
        final int success = jdbcTemplate.update("INSERT INTO " + notificationsTableName + " (id, sourceId, dateTime, details) " +
                        "VALUES(?,?,?,?)", generatedUUID, notification.getSourceId(), notification.getDateTime(),
                         notification.getDetails());
        if(success == 1)
            return generatedUUID;
        return "Unable to insert a new notification";
    }

    @Override
    public List<Notification> selectAllNotifications() {
        return jdbcTemplate.query("SELECT * FROM " + notificationsTableName, new NotificationRowMapper());
    }
    
    @Override
    public Notification selectNotificationById(String id) {
        return selectAllNotifications().stream()
                .filter(notification -> (notification.getId().equals(id)))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteNotificationById(String id) {
        return jdbcTemplate.update("DELETE FROM " + notificationsTableName + " WHERE id = ?", new Object[] {id});
    }

}
