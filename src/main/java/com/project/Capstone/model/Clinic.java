package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clinic {
    private String clinicName;
    private int clinicalSupervisorId;
    private int yearFounded;
    private String description;
    private boolean active;

    public Clinic(@JsonProperty("clinicName") String clinicName,
                  @JsonProperty("clinicalSupervisorId") int clinicalSupervisorId,
                  @JsonProperty("description") String description,
                  @JsonProperty("yearFounded") int yearFounded,
                  @JsonProperty("active") boolean active) {
        this.clinicName = clinicName;
        this.clinicalSupervisorId = clinicalSupervisorId;
        this.yearFounded = yearFounded;
        this.description = description;
        this.active = active;
    }

    public String getClinicName() {
        return clinicName;
    }

    public int getClinicalSupervisorId() {
        return clinicalSupervisorId;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }
}
