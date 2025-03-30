package com.example.batchmaster.repository;

import com.example.batchmaster.model.Batch;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatchRepository extends MongoRepository<Batch, String> {

    Optional<Batch> findByBatchName(String batchName);


    List<Batch> findAllByBranchId(String branchId);
}
