package com.example.batchMaster.repository;

import com.example.batchMaster.model.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarksRepository extends MongoRepository<Marks,String> {
}
