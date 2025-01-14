package com.ing.orchestrator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("cin")
    private String cin;

    @JsonProperty("salary")
    private Double salary;

    @JsonProperty("birthdate")
    private String birthdate; // Keep as String if using JSON

    @JsonProperty("contract")
    private String contract;

    // Constructors, Getters, and Setters
    public ClientDto() {}

    public ClientDto(String name, String lastname, String cin, Double salary, String birthdate, String contract) {
        this.name = name;
        this.lastname = lastname;
        this.cin = cin;
        this.salary = salary;
        this.birthdate = birthdate;
        this.contract = contract;
    }

    // Getters and setters omitted for brevity
}
