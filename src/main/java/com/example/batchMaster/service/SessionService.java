package com.example.batchMaster.service;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;

import java.util.List;

public interface SessionService {
    Session createSession(SessionCreateRequest session);

    Session updateSession(SessionUpdateRequest session);

    List<Session> getSessionsByBatchId(String batchId);

    List<Session> getSessionsBySubject(String subject);

    Session getSessionById(String sessionId);

    boolean deleteSessionById(String sessionId);

    Session getLastSessionByBatchId(String batchId);


    List<Session> getAllSessionsOfAllBatchesByBranchId(String branch);

    List<Session> getAllSessionsOfAllBatchesBySubjectAndTopic(String subject, String topic);

    List<Session> getAllLastSessionsOfAllBatchesByBranchId(String branch);


    List<Session> getSessionsByDate(String date);



}
