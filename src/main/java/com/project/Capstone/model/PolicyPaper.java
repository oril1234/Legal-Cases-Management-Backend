package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolicyPaper {
    private final int id;
    private final String clinicName;
    private final String subject;
    private final String policyType;
    private final String status;

    public PolicyPaper(@JsonProperty("id") int id,
                       @JsonProperty("clinicName") String clinicName,
                       @JsonProperty("subject") String subject,
                       @JsonProperty("policyType") String policyType,
                       @JsonProperty("status") String status) {
        this.id = id;
        this.clinicName = clinicName;
        this.subject = subject;
        this.policyType = policyType;
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

    public String getPolicyType() {
        return policyType;
    }

    public String getStatus() {
        return status;
    }

}
