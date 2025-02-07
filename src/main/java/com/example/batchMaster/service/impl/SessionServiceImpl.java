package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;
import com.example.batchMaster.repository.SessionRepository;
import com.example.batchMaster.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session createSession(SessionCreateRequest sessionCreateRequest) {
        if (sessionCreateRequest == null) {
            throw new IllegalArgumentException("Session request cannot be null");
        }

        Session session = new Session();
        session.setSubject(sessionCreateRequest.getSubject());
        session.setTopic(sessionCreateRequest.getTopic());
        session.setMentor(sessionCreateRequest.getMentor());
        session.setSessionLink(sessionCreateRequest.getSessionLink());
        session.setDate(sessionCreateRequest.getDate());
        session.setBatchId(sessionCreateRequest.getBatchId());

        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession( SessionUpdateRequest updatedSession) {
        Optional<Session> existingSessionOpt = sessionRepository.findById(updatedSession.getBatchId());
        if (existingSessionOpt.isPresent()) {
            Session existingSession = existingSessionOpt.get();
            existingSession.setSubject(updatedSession.getSubject());
            existingSession.setTopic(updatedSession.getTopic());
            existingSession.setMentor(updatedSession.getMentor());
            existingSession.setSessionLink(updatedSession.getSessionLink());
            existingSession.setDate(updatedSession.getDate());
            existingSession.setBatchId(updatedSession.getBatchId());
            return sessionRepository.save(existingSession);
        }
        throw new RuntimeException("Session not found with ID: " + updatedSession.getBatchId());
    }

    @Override
    public List<Session> getSessionsByBatchId(String batchId) {
        return sessionRepository.findAllByBatchId(batchId);
    }

    @Override
    public List<Session> getSessionsBySubject(String subject) {
        return sessionRepository.findAllBySubject(subject);
    }
}
