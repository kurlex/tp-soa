package com.ing.idl.BCT_service.service.impl;

import com.ing.idl.BCT_service.dto.BlacklistDto;
import com.ing.idl.BCT_service.entity.BlacklistEntity;
import com.ing.idl.BCT_service.mapper.impl.BlacklistMapper;
import com.ing.idl.BCT_service.repository.BCTRepository;
import com.ing.idl.BCT_service.service.BCTService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BCTServiceImpl implements BCTService {

    private final BCTRepository bctRepository;
    private final BlacklistMapper blacklistMapper;

    public BCTServiceImpl(BCTRepository bctRepository, BlacklistMapper blacklistMapper) {
        this.bctRepository = bctRepository;
        this.blacklistMapper = blacklistMapper;
    }


    @Override
    public BlacklistDto addBCT(BlacklistDto blacklistDto) {
        BlacklistEntity bctEntity = blacklistMapper.toEntity(blacklistDto);
        BlacklistEntity bct = bctRepository.save(bctEntity);
        return blacklistMapper.toDto(bct);
    }


    @Override
    public boolean checkClientInBlacklist(Long clientCIN) {
        Optional<BlacklistEntity> blacklistEntity = bctRepository.findByClientCIN(clientCIN);
        return blacklistEntity.isPresent();
    }

}
