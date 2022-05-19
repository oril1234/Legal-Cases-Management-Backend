package com.project.Capstone.dao;

import com.project.Capstone.model.LegislativeProposal;
import com.project.Capstone.model.Notification;
import com.project.Capstone.model.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notificationManagerDao")
public class NotificationManagerDataAccessService implements NotificationManagerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String notificationsManagerTableName = "NOTIFICATIONMANAGER";

    @Override
    public int insertNotificationManager(NotificationManager notificationManager) {
        return jdbcTemplate.update("INSERT INTO " + notificationsManagerTableName + " (notificationId, receiverId, unread) " +
                        "VALUES(?,?,true)", notificationManager.getNotificationId(), notificationManager.getReceiverId());
    }

    @Override
    public List<Notification> selectNotificationsForPersonId(int personId) {
        return jdbcTemplate.query("SELECT NOTIFICATIONS.id, NOTIFICATIONS.sourceId," +
                " NOTIFICATIONS.dateTime, NOTIFICATIONS.details FROM NOTIFICATIONS, NOTIFICATIONMANAGER" +
                " WHERE NOTIFICATIONS.id=NOTIFICATIONMANAGER.notificationId AND" +
                " NOTIFICATIONMANAGER.receiverId=" + personId, new NotificationRowMapper());
    }

    @Override
    public List<Notification> selectAllNotificationsFromNotificationManager() {
        return jdbcTemplate.query("SELECT * FROM " + notificationsManagerTableName, new NotificationRowMapper());
    }

    @Override
    public List<NotificationManager> selectAllNotificationManagers() {
        return jdbcTemplate.query("SELECT * FROM " + notificationsManagerTableName, new NotificationManagerRowMapper());
    }

    @Override
    public int deleteNotificationManagerById(String id) {
        return jdbcTemplate.update("DELETE FROM " + notificationsManagerTableName + " WHERE notificationId = ?", new Object[] {id});
    }

    @Override
    public int deleteNotificationManagerByNotificationIdAndReceiverId(String id, int receiverId) {
        return jdbcTemplate.update("DELETE FROM " + notificationsManagerTableName + " WHERE notificationId = '" + id + "' AND receiverId = " +receiverId);
    }

    /**
     * @param receiverId of the person that read his/her notifications
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateNotificationsOfPersonToRead(int receiverId) {
        return jdbcTemplate.update("UPDATE " + notificationsManagerTableName + " SET unread=0 WHERE unread=1 AND receiverId = " + receiverId);
    }

    @Override
    public int numberOfUnreadNotificationPerPerson(int receiverId) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + notificationsManagerTableName + " WHERE unread=1 AND receiverId =" +receiverId, Integer.class);
    }

}
