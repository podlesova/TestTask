package com.example.testTask4.repository;

import com.example.testTask4.model.BankEntity;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository  extends CrudRepository<BankEntity, String> {
}
