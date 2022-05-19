package com.project.Capstone.dao;

import com.project.Capstone.model.Notification;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationRowMapper implements RowMapper<Notification> {

    @Override
    public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Notification notification = new Notification(rs.getString("id"),
                rs.getInt("sourceId"),
                rs.getDate("dateTime"),
                rs.getString("details"));

        return notification;
    }
}
