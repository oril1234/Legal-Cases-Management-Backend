package com.project.Capstone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Transportation {

    private final int transportId;
    private final int clinicalSupervisorId;
    private final LocalDateTime transportDate;
    private final String destination;

    public Transportation(@JsonProperty("transportId") int transportId,
                          @JsonProperty("clinicalSupervisorId") int clinicalSupervisorId,
                          @JsonProperty("transportDate") LocalDateTime transportDate,
                          @JsonProperty("destination") String destination) {
        this.transportId = transportId;
        this.clinicalSupervisorId = clinicalSupervisorId;
        this.transportDate = transportDate;
        this.destination = destination;
    }

    public int getTransportId() {
        return transportId;
    }

    public int getClinicalSupervisorId() {
        return clinicalSupervisorId;
    }

    public LocalDateTime getTransportDate() {
        return transportDate;
    }

    public String getDestination() {
        return destination;
    }
}
