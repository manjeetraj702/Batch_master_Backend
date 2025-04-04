package com.example.batchmaster.repository;

import com.example.batchmaster.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {

    // Retrieve all sessions by batchId (Indexed)
    List<Session> findAllByBatchId(String batchId);

    // Retrieve all sessions by subject (Indexed)
    List<Session> findAllBySubject(String subject);

    // Retrieve the latest session for a batch by createdAt (Indexed)
    Optional<Session> findTopByBatchIdOrderByCreatedAtDesc(String batchId);

    // Retrieve all sessions by branchId (Indexed)
    List<Session> findAllByBranchId(String branchId);

    // 🔥 Retrieve all sessions for a specific date (Exact match)
    List<Session> findAllByDate(Date date);

    // 🔥 Retrieve all sessions for a specific batchId and exact date
    List<Session> findAllByBatchIdAndDate(String batchId, Date date);

    // 🔥 Retrieve all sessions from a particular date onwards (Globally)
    List<Session> findAllByDateAfter(Date fromDate);

    // 🔥 Retrieve all sessions from a particular date onwards for a specific batchId
    List<Session> findAllByBatchIdAndDateAfter(String batchId, Date fromDate);

    // 🔥 Retrieve all sessions up to a particular date (Globally)
    List<Session> findAllByDateBefore(Date toDate);

    // 🔥 Retrieve all sessions up to a particular date for a specific batchId
    List<Session> findAllByBatchIdAndDateBefore(String batchId, Date toDate);

    // 🔥 Retrieve all sessions between two dates (Inclusive, Globally)
    List<Session> findAllByDateBetween(Date startDate, Date endDate);

    // 🔥 Retrieve all sessions between two dates (Inclusive) for a specific batchId
    List<Session> findAllByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    // Retrieve all sessions by subject and topic (Indexed)
    List<Session> findAllBySubjectAndTopic(String subject, String topic);

    // Retrieve all sessions by batchId and subject (Indexed)
    List<Session> findAllByBatchIdAndSubject(String batchId, String subject);
}
