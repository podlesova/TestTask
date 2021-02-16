package com.example.testTask4.service;

import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.model.CreditEntity;
import com.example.testTask4.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    private  final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<CreditEntity> findAll()  {
        Iterable<CreditEntity> creditEntities = creditRepository.findAll();
        ArrayList<CreditEntity> creditEntityArrayList = new ArrayList<>();
        for (CreditEntity creditEntity : creditEntities)
            creditEntityArrayList.add(creditEntity);
        return creditEntityArrayList;
    }

    public void delete(String id){
        creditRepository.deleteById(id);
    }

    public void save(CreditEntity creditEntity){
        creditRepository.save(creditEntity);
    }
    public CreditEntity findById(String id){
        return creditRepository.findById(id).get();
    }
}
