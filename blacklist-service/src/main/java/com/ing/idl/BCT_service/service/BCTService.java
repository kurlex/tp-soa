package com.ing.idl.BCT_service.service;

import com.ing.idl.BCT_service.dto.BlacklistDto;

public interface BCTService {
    BlacklistDto addBCT(BlacklistDto blacklistDto);
    boolean checkClientInBlacklist(Long clientCIN);
}
