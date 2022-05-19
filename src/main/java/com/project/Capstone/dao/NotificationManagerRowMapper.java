package com.project.Capstone.dao;

import com.project.Capstone.model.NotificationManager;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationManagerRowMapper implements RowMapper<NotificationManager> {

    @Override
    public NotificationManager mapRow(ResultSet rs, int rowNum) throws SQLException {
        final NotificationManager notificationManager = new NotificationManager(rs.getString("notificationId"),
                rs.getInt("receiverId"),
                rs.getBoolean("unread"));

        return notificationManager;
    }
}
