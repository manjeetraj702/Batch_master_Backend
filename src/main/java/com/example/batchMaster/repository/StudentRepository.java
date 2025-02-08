package com.example.batchMaster.repository;

import com.example.batchMaster.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {

    List<Student> findAllByBatchId(String batchId);
    List<Student> findAllByBatchIdAndModeFalse(String batchId);
    List<Student> findAllByBatchIdAndModeTrue(String batchId);


    Optional<Student> findByEmail(String email);
}
