package com.ing.soaproject.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
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


}

