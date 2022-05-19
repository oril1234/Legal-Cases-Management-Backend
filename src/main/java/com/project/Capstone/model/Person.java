package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role; // Super Admin, Admin, Student, Client
    private String imgUrl;

    public Person(@JsonProperty("id") int id,
                  @JsonProperty("password") String password,
                  @JsonProperty("firstName") String firstname,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("email") String email,
                  @JsonProperty("phoneNumber") String phoneNumber,
                  @JsonProperty("role") String role,
                  @JsonProperty("imgUrl") String imgUrl) {
        this.id = id;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
