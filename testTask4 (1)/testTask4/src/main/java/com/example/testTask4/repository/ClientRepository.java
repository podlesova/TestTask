package com.example.testTask4.repository;

import com.example.testTask4.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, String> {
}
