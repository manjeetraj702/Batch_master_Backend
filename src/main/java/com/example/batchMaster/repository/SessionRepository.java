package com.example.batchMaster.repository;

import com.example.batchMaster.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {

    List<Session> findAllByBatchId(String batchId);

    List<Session> findAllBySubject(String subject);

    Optional<Session> findTopByBatchIdOrderByCreatedAtDesc(String batchId);
}
