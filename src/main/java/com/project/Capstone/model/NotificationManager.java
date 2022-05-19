package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationManager {

    private String notificationId;
    private int receiverId;
    private boolean unread;

    public NotificationManager(@JsonProperty("notificationId") String notificationId,
                               @JsonProperty("receiverId") int receiverId,
                               @JsonProperty("unread") boolean unread) {
        this.notificationId = notificationId;
        this.receiverId = receiverId;
        this.unread = unread;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public boolean getUnread() {
        return unread;
    }
}
