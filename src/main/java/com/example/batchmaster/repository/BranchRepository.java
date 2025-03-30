package com.example.batchmaster.repository;

import com.example.batchmaster.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends MongoRepository<Branch, String> {
    Optional<Branch> findByBranchId(String branchId);

    Optional<Branch> findByBranchName(String branchName);

}
