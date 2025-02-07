package com.example.batchMaster.service;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;

import java.util.List;

public interface SessionService {
    Session createSession(SessionCreateRequest session);
    Session updateSession(SessionUpdateRequest  session);
    List<Session> getSessionsByBatchId(String batchId);
    List<Session> getSessionsBySubject(String subject);
}
