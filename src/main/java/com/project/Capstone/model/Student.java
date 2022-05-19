package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends Person {

    private final int clinicalSupervisorId;

    public Student(@JsonProperty("id") int id,
                   @JsonProperty("password") String password,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("email") String email,
                   @JsonProperty("phoneNumber") String phoneNumber,
                   @JsonProperty("role") String role,
                   @JsonProperty("imgUrl") String imgUrl,
                   @JsonProperty("clinicalSupervisorId") int clinicalSupervisorId) {
        super(id, password, firstName, lastName, email, phoneNumber, role, imgUrl);
        this.clinicalSupervisorId = clinicalSupervisorId;
    }

    public int getClinicalSupervisorId() {
        return clinicalSupervisorId;
    }
}
