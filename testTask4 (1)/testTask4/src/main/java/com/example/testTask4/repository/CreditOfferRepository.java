package com.example.testTask4.repository;

import com.example.testTask4.model.CreditOfferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CreditOfferRepository extends CrudRepository<CreditOfferEntity, String> {
}
