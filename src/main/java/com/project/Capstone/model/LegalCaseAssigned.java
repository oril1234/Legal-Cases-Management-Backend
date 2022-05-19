package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LegalCaseAssigned {
    private final int legalCaseId;
    private final int studentId;
    private final Date dateAssigned;
    private final String taskDescription;
    private final Date dueDate;

    public LegalCaseAssigned(@JsonProperty("legalCaseId") int legalCaseId,
                             @JsonProperty("studentId") int studentId,
                             @JsonProperty("dateAssigned") Date dateAssigned,
                             @JsonProperty("taskDescription") String taskDescription,
                             @JsonProperty("dueDate") Date dueDate) {
        this.legalCaseId = legalCaseId;
        this.studentId = studentId;
        this.dateAssigned = dateAssigned;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
    }

    public int getLegalCaseId() {
        return legalCaseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
