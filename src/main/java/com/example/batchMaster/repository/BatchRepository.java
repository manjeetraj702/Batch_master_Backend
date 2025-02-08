package com.example.batchMaster.repository;

import com.example.batchMaster.model.Batch;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends MongoRepository<Batch,String> {

    Optional<Batch> findByBatchId(String batchId);
    Optional<Batch> findByBatchName(String batchName);
}
