package com.example.batchmaster.repository;

import com.example.batchmaster.model.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends MongoRepository<Marks, String> {

    List<Marks> findAllByStudentId(String studentId);


    List<Marks> findAllBySubjectAndTopicAndBatchId(String subject, String topic, String batchId);

    void deleteAllByResultId(String resultId);

    List<Marks> findAllByResultId(String resultId);
}
