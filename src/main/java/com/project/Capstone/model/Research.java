package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Research {
    private final int id;
    private final String clinicName;
    private final String subject;
    private final String researchType;
    private final String status;

    public Research(@JsonProperty("id") int id,
                    @JsonProperty("clinicName") String clinicName,
                    @JsonProperty("subject") String subject,
                    @JsonProperty("researchType") String researchType,
                    @JsonProperty("status") String status) {
        this.id = id;
        this.clinicName = clinicName;
        this.subject = subject;
        this.researchType = researchType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getSubject() {
        return subject;
    }

    public String getResearchType() {
        return researchType;
    }

    public String getStatus() {
        return status;
    }

}
