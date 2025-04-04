package com.example.batchmaster.repository;

import com.example.batchmaster.model.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MarksRepository extends MongoRepository<Marks, String> {

    List<Marks> findAllByStudentId(String studentId);

    List<Marks> findAllBySubjectAndTopicAndBatchId(String subject, String topic, String batchId);

    void deleteAllByResultId(String resultId);

    List<Marks> findAllByResultId(String resultId);

    List<Marks> findAllByBatchId(String batchId);

    List<Marks> findAllByBatchIdAndSubject(String batchId, String subject);

    List<Marks> findAllByBatchIdAndTopic(String batchId, String topic);

    // New Optimized Methods
    List<Marks> findAllByBatchIdAndDate(String batchId, Date date);

    List<Marks> findAllByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    List<Marks> findAllByBatchIdAndSubjectAndDate(String batchId, String subject, Date date);

    List<Marks> findAllByBatchIdAndSubjectAndTopicAndDate(String batchId, String subject, String topic, Date date);
}
