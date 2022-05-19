package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentInTransport {

    private final int transportId;
    private final int studentId;

    public StudentInTransport(@JsonProperty("transportId") int transportId,
                              @JsonProperty("studentId") int studentId) {
        this.transportId = transportId;
        this.studentId = studentId;
    }

    public int getTransportId() {
        return transportId;
    }

    public int getStudentId() {
        return studentId;
    }
}
