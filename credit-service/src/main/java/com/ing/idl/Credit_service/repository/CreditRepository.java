package com.ing.idl.Credit_service.repository;

import com.ing.idl.Credit_service.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
    Optional<List<CreditEntity>> findByClientId(Long clientId);
}
