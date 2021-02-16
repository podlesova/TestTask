package com.example.testTask4.service;

import com.example.testTask4.model.ClientEntity;
import com.example.testTask4.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private  final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientEntity> findAll()  {
        Iterable<ClientEntity> clientEntities = clientRepository.findAll();
        ArrayList<ClientEntity> clientEntityArrayList = new ArrayList<>();
        for (ClientEntity clientEntity : clientEntities)
            clientEntityArrayList.add(clientEntity);
        return  clientEntityArrayList;
    }

    public void delete(String id){
        clientRepository.deleteById(id);
    }

    public void save(ClientEntity clientEntity){
        clientRepository.save(clientEntity);
    }
    public ClientEntity findById(String id){
        return clientRepository.findById(id).get();
    }
}
