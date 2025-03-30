package com.example.batchmaster.repository;

import com.example.batchmaster.model.Session;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {

    List<Session> findAllByBatchId(String batchId);

    List<Session> findAllBySubject(String subject);

    Optional<Session> findTopByBatchIdOrderByCreatedAtDesc(String batchId);

    @Aggregation(pipeline = {
            "{ $match: { branchId: ?0 } }",
            "{ $sort: { createdAt: -1 } }",
            "{ $group: { _id: '$batchId', lastSession: { $first: '$$ROOT' } } }",
            "{ $replaceRoot: { newRoot: '$lastSession' } }"
    })
    List<Session> findLastSessionForEachBatchByBranchId(String branchId);


    List<Session> findAllByBranchId(String branch);

    List<Session> findAllByDate(String date);

    List<Session> findAllBySubjectAndTopic(String subject, String topic);

    List<Session> findAllByBatchIdAndSubject(String batchId, String subject);
}
