package com.ing.idl.BCT_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistDto {
    private Long id;
    private Long clientCIN ;
}
