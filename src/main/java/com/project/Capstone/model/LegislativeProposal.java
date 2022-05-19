package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LegislativeProposal {
    private final int id;
    private final String clinicName;
    private final String subject;
    private final String proposalType;
    private final String status;

    public LegislativeProposal(@JsonProperty("id") int id,
                               @JsonProperty("clinicName") String clinicName,
                               @JsonProperty("subject") String subject,
                               @JsonProperty("proposalType") String proposalType,
                               @JsonProperty("status") String status) {
        this.id = id;
        this.clinicName = clinicName;
        this.subject = subject;
        this.proposalType = proposalType;
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

    public String getProposalType() {
        return proposalType;
    }

    public String getStatus() {
        return status;
    }

}
