package com.example.batchMaster.repository;

import com.example.batchMaster.model.BatchSubject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchSubjectRepository extends MongoRepository<BatchSubject,String> {



    List<BatchSubject> findAllByBatchId(String batchId);

    List<BatchSubject> findAllByBatchIdAndStatusTrue(String batchId);
    List<BatchSubject> findAllByBatchIdAndStatusFalse(String batchId);
    BatchSubject findBySubjectNameAndBatchId(String subjectName, String batchId);
}
