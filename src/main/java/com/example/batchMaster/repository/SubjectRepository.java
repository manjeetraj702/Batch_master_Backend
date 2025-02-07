package com.example.batchMaster.repository;

import com.example.batchMaster.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String> {




}
