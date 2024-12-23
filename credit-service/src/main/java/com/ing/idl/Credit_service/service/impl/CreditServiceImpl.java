package com.ing.idl.Credit_service.service.impl;

import com.ing.idl.Credit_service.dto.CreditDto;
import com.ing.idl.Credit_service.entity.CreditEntity;
import com.ing.idl.Credit_service.mapper.impl.CreditMapper;
import com.ing.idl.Credit_service.repository.CreditRepository;
import com.ing.idl.Credit_service.service.CreditService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(CreditRepository creditRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public CreditDto addCredit(CreditEntity creditEntity) {
        CreditEntity credit = creditRepository.save(creditEntity);
        CreditDto creditDto = creditMapper.toDto(credit);
        creditDto.setMonthlyPayment(calculateMonthlyPayment(creditDto));
        return creditDto;
    }


    @Override
    public List<CreditDto> getCreditByClientId(Long clientId) {
        Optional<List<CreditEntity>> creditEntityOptional = creditRepository.findByClientId(clientId);

        if (creditEntityOptional.isEmpty()) {
            return null;
        }

        List<CreditEntity> creditEntities = creditEntityOptional.get();
        List<CreditDto> creditDtos = creditMapper.toDto(creditEntities);

        for (CreditDto creditDto : creditDtos) {
            creditDto.setMonthlyPayment(calculateMonthlyPayment(creditDto));
        }
        return creditDtos;
    }

    private Double calculateMonthlyPayment(CreditDto creditDto) {
        if (creditDto.getDurationInMonth() == 0 || creditDto.getAmount() == null || creditDto.getInterest() == null) {
            return 0.0;
        }

        double interestAmount = creditDto.getAmount() * creditDto.getInterest() / 100;
        double totalAmount = creditDto.getAmount() + interestAmount;
        double months = creditDto.getDurationInMonth();
        return totalAmount / months;
    }
}
