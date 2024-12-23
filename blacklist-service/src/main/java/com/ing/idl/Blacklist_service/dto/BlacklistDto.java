package com.ing.idl.Blacklist_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistDto {
    private Long id;
    private Long clientCIN ;
}
