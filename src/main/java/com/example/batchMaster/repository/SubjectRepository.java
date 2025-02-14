package com.example.batchMaster.repository;

import com.example.batchMaster.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String> {

    Optional<Subject> findBySubjectName(String subjectName);
}
