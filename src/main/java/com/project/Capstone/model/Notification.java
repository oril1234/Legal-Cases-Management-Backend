package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Notification {

    private String id;
    private int sourceId;
    private Date dateTime;
    private String details;

    public Notification(@JsonProperty("id") String id,
                        @JsonProperty("sourceId") int sourceId,
                        @JsonProperty("dateTime") Date dateTime,
                        @JsonProperty("details") String details) {
        this.id = id;
        this.sourceId = sourceId;
        this.dateTime = dateTime;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getDetails() {
        return details;
    }
}
