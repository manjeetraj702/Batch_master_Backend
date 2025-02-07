package com.example.batchMaster.repository;

import com.example.batchMaster.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
