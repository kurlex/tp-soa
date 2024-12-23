package com.ing.idl.Blacklist_service.dto;

import com.ing.idl.Blacklist_service.entity.ContractEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistDto {
    private Long id;
    private String name;
    private String lastname;
    private String CIN;
    private Double salary;
    private Date birthdate;
    private ContractEnum contract;
}
