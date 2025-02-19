package com.example.batchMaster.repository;

import com.example.batchMaster.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {

    List<Result> findByBatchIdAndSubject(String batchId, String subject);


    List<Result> findAllByBatchId(String batchId);

    Result findByBatchIdAndSubjectAndTopic(String batchId, String subject, String topic);
}
