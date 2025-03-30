package com.example.batchmaster.repository;

import com.example.batchmaster.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAllByBatchId(String batchId);

    List<Student> findAllByBatchIdAndStudyModeFalse(String batchId);

    List<Student> findAllByBatchIdAndStudyModeTrue(String batchId);

    Optional<Student> findByEmail(String email);

    List<Student> findAllByBranchId(String branchId);
}
