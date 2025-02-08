package com.example.batchMaster.repository;

import com.example.batchMaster.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String> {



    List<Subject> findAllByBatchId(String batchId);

    List<Subject> findAllByStatusTrue();
    List<Subject> findAllByStatusFalse();

}
