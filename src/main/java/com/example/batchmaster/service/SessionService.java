package com.example.batchmaster.service;

import com.example.batchmaster.model.Session;
import com.example.batchmaster.model.request.SessionCreateRequest;
import com.example.batchmaster.model.updaterequest.SessionUpdateRequest;

import java.util.Date;
import java.util.List;

public interface SessionService {
    // Create a new session
    Session createSession(SessionCreateRequest session);

    // Update an existing session
    Session updateSession(SessionUpdateRequest session);

    // Retrieve all sessions by batchId
    List<Session> getSessionsByBatchId(String batchId);

    // Retrieve all sessions by subject
    List<Session> getSessionsBySubject(String subject);

    // Retrieve a session by its ID
    Session getSessionById(String sessionId);

    // Delete a session by its ID
    boolean deleteSessionById(String sessionId);

    // Retrieve the latest session by batchId
    Session getLastSessionByBatchId(String batchId);

    // Retrieve all sessions for all batches by branchId
    List<Session> getAllSessionsOfAllBatchesByBranchId(String branch);

    // Retrieve all sessions by subject and topic
    List<Session> getAllSessionsOfAllBatchesBySubjectAndTopic(String subject, String topic);

    // Retrieve the last sessions of all batches by branchId
    // Retrieve all sessions by exact date
    List<Session> getSessionsByDate(Date date);

    // Retrieve all sessions by batchId and subject
    List<Session> getAllSessionsByBatchIdAndSubject(String batchId, String subject);

    // 🔥 Retrieve all sessions by batchId and exact date
    List<Session> getSessionsByBatchIdAndDate(String batchId, Date date);

    // 🔥 Retrieve all sessions by batchId from a particular date onwards
    List<Session> getSessionsByBatchIdAndDateAfter(String batchId, Date fromDate);

    // 🔥 Retrieve all sessions by batchId up to a particular date
    List<Session> getSessionsByBatchIdAndDateBefore(String batchId, Date toDate);

    // 🔥 Retrieve all sessions by batchId between two dates (inclusive)
    List<Session> getSessionsByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate);

    // 🔥 Retrieve all sessions globally from a particular date onwards
    List<Session> getSessionsByDateAfter(Date fromDate);

    // 🔥 Retrieve all sessions globally up to a particular date
    List<Session> getSessionsByDateBefore(Date toDate);

    // 🔥 Retrieve all sessions globally between two dates (inclusive)
    List<Session> getSessionsByDateBetween(Date startDate, Date endDate);
}
