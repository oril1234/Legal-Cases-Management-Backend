package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client extends Person {

    public Client(@JsonProperty("id") int id,
                  @JsonProperty("password") String password,
                  @JsonProperty("firstName") String firstname,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("email") String email,
                  @JsonProperty("phoneNumber") String phoneNumber,
                  @JsonProperty("role") String role,
                  @JsonProperty("imgUrl") String imgUrl) {
        super(id, password, firstname, lastName, email, phoneNumber, role, imgUrl);
    }

}
