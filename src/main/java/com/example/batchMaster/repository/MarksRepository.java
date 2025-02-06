package com.example.batchMaster.repository;

import com.example.batchMaster.model.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MarksRepository extends MongoRepository<Marks, String> {

    List<Marks> findAllByStudentId(String studentId);

    List<Marks> findByTopicAndBatchId(String topic, String batchId);

    List<Marks> findAllBySubjectAndTopicAndBatchId(String subject, String topic, String batchId);
}
