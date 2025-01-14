package com.ing.soaproject.models;


import java.util.Date;

public class ClientDto {
    private Long id;
    private String name;
    private String lastname;
    private String cin;
    private Double salary;
   // private Date birthdate;
   private String birthdate;
   // private ContractEnum contract;
   private String contract;

    public ClientDto(String name, String lastname, String cin, Double salary, String birthdate, String contract) {
        this.name = name;
        this.lastname = lastname;
        this.cin = cin;
        this.salary = salary;
        this.birthdate = birthdate;
        this.contract = contract;
    }
}

