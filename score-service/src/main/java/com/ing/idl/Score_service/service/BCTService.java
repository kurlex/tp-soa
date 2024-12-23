package com.ing.idl.Score_service.service;

import com.ing.idl.Score_service.dto.BlacklistRequestDto;
import com.ing.idl.Score_service.dto.ContractEnum;
import com.ing.idl.Score_service.dto.ScoreDto;
import com.ing.idl.Score_service.entity.ScoreEntity;

public interface BCTService {
    boolean checkClient(BlacklistRequestDto blacklistRequestDto);
}
