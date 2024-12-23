package com.ing.idl.Decision_service.repository;

import com.ing.idl.Decision_service.entity.DecisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DecisionRepository extends JpaRepository<DecisionEntity, Long> {
}
