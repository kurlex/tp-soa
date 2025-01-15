package com.ing.soaproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlacklistDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("clientCIN")
    private Long clientCIN ;

    public BlacklistDto(Long clientCIN) {
        this.clientCIN = clientCIN;
    }
}
