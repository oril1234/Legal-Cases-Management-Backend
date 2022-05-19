package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LegalCase {
    private int id;
    private Date dateAdded;
    private String subject;
    private String caseType;
    private String status;
    private int courtCaseId;
    private String clinicName;
    private int clientId;

    @JsonCreator
    public LegalCase(@JsonProperty("id") int id,
                     @JsonProperty("dateAdded") Date dateAdded,
                     @JsonProperty("subject") String subject,
                     @JsonProperty("caseType") String caseType,
                     @JsonProperty("status") String status,
                     @JsonProperty("courtCaseId") int courtCaseId,
                     @JsonProperty("clinicName") String clinicName,
                     @JsonProperty("clientId") int clientId) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.subject = subject;
        this.caseType = caseType;
        this.status = status;
        this.courtCaseId = courtCaseId;
        this.clinicName = clinicName;
        this.clientId = clientId;
    }

    // For Deserialization
    public LegalCase() {
    }

    public int getId() {
        return id;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getSubject() {
        return subject;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getStatus() {
        return status;
    }

    public int getCourtCaseId() {
        return courtCaseId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClinicName() {
        return clinicName;
    }
}
