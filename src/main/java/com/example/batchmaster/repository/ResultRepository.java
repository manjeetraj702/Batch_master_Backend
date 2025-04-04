package com.example.batchmaster.repository;

import com.example.batchmaster.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {

    // Find results by batchId and subject
    List<Result> findByBatchIdAndSubject(String batchId, String subject);

    // Find all results by batchId
    List<Result> findAllByBatchId(String batchId);

    // Find a specific result by batchId, subject, and topic
    Result findByBatchIdAndSubjectAndTopic(String batchId, String subject, String topic);

    // Find results by batchId and date
    List<Result> findByBatchIdAndDate(String batchId, Date date);

    // Find results by batchId within a date range
    List<Result> findByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    // Find results by subject
    List<Result> findBySubject(String subject);

    // Find results by topic
    List<Result> findByTopic(String topic);
}
