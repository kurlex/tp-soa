package com.ing.idl.Blacklist_service.service;

import com.ing.idl.Blacklist_service.dto.BlacklistDto;

public interface BlacklistService {
    BlacklistDto addBlacklist(BlacklistDto blacklistDto);
    BlacklistDto getBlacklistByClientCIN(Long clientCIN);
}
