package com.example.testTask4.service;

import com.example.testTask4.model.PlanEntity;
import com.example.testTask4.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanService {

    private  final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Iterable<PlanEntity> findAll()  {
        return planRepository.findAll();
    }

    public List<PlanEntity> findByCreditOffer(String creditOffer)  {
        return planRepository.findByCreditOffer_IdOrderByDate(creditOffer);
    }

    public void saveAll(List<PlanEntity> planEntities)  {
         planRepository.saveAll(planEntities);
    }
}
