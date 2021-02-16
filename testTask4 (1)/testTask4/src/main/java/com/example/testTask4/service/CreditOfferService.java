package com.example.testTask4.service;

import com.example.testTask4.model.CreditOfferEntity;
import com.example.testTask4.repository.CreditOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditOfferService {

    private  final CreditOfferRepository creditOfferRepository;

    @Autowired
    public CreditOfferService(CreditOfferRepository creditOfferRepository) {
        this.creditOfferRepository = creditOfferRepository;
    }

    public List<CreditOfferEntity> findAll()  {
        Iterable<CreditOfferEntity> creditOfferEntities = creditOfferRepository.findAll();
        ArrayList<CreditOfferEntity> creditOfferEntityArrayList = new ArrayList<>();
        for (CreditOfferEntity creditOfferEntity : creditOfferEntities)
            creditOfferEntityArrayList.add(creditOfferEntity);
        return  creditOfferEntityArrayList;
    }

    public void delete(String id){
        creditOfferRepository.deleteById(id);
    }

    public CreditOfferEntity save(CreditOfferEntity creditOfferEntity){
        return creditOfferRepository.save(creditOfferEntity);
    }
}
