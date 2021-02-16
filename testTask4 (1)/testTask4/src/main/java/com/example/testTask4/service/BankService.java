package com.example.testTask4.service;

import com.example.testTask4.model.BankEntity;
import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.repository.BankRepository;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<BankEntity> findAll()  {
        Iterable<BankEntity> bankEntities = bankRepository.findAll();
        ArrayList<BankEntity> bankEntityArrayList = new ArrayList<>();
        for (BankEntity bankEntity : bankEntities)
            bankEntityArrayList.add(bankEntity);
        return bankEntityArrayList;
    }

    public void delete(String id){
        bankRepository.deleteById(id);
    }

    public void save(BankEntity bankEntity){
        bankRepository.save(bankEntity);
    }

    public BankEntity findById(String id){
        return bankRepository.findById(id).get();
    }
}
