package com.example.batchMaster.repository;

import com.example.batchMaster.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {

    List<Student> findAllByBatchId(String batchId);
    List<Student> findByBatchIdAndStatusFalse(String batchId);
    List<Student> findByBatchIdAndStatusTrue(String batchId);


}
