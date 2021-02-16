package com.example.testTask4.repository;

import com.example.testTask4.model.PlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanRepository extends CrudRepository<PlanEntity, String> {

    List<PlanEntity> findByCreditOffer_IdOrderByDate(String creditOffer);
}
