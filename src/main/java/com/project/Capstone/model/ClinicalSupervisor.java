package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClinicalSupervisor extends Person {

    private final int sinceYear;

    public ClinicalSupervisor(@JsonProperty("id") int id,
                              @JsonProperty("password") String password,
                              @JsonProperty("firstName") String firstName,
                              @JsonProperty("lastName") String lastName,
                              @JsonProperty("email") String email,
                              @JsonProperty("phoneNumber") String phoneNumber,
                              @JsonProperty("role") String role,
                              @JsonProperty("imgUrl") String imgUrl,
                              @JsonProperty("sinceYear") int sinceYear) {
        super(id, password, firstName, lastName, email, phoneNumber, role, imgUrl);
        this.sinceYear = sinceYear;
    }

    public int getSinceYear() {
        return sinceYear;
    }
}
