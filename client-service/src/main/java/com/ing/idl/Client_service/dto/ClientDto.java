package com.ing.idl.Client_service.dto;

import com.ing.idl.Client_service.entity.ContractEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String lastname;
    private String cin;
    private Double salary;
    private Date birthdate;
    private ContractEnum contract;


}

