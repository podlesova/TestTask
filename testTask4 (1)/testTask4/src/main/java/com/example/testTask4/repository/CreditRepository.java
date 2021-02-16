package com.example.testTask4.repository;

import com.example.testTask4.model.CreditEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreditRepository extends CrudRepository<CreditEntity, String> {
}
