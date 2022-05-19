package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CaseAssignedSupervisorsList {
    private final int id;
    private final String studentName;
    private final Date dateAssigned;
    private final String status;
    private final String subject;
    private final String taskDescription;
    private final Date dueDate;

    public CaseAssignedSupervisorsList(@JsonProperty("id") int id,
                                       @JsonProperty("studentName") String studentName,
                                       @JsonProperty("dateAssigned") Date dateAssigned,
                                       @JsonProperty("status") String status,
                                       @JsonProperty("subject") String subject,
                                       @JsonProperty("taskDescription") String taskDescription,
                                       @JsonProperty("dueDate") Date dueDate) {
        this.id = id;
        this.studentName = studentName;
        this.dateAssigned = dateAssigned;
        this.status = status;
        this.subject = subject;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public String getStatus() {
        return status;
    }

    public String getSubject() {
        return subject;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
