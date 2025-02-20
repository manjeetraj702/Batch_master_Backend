package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;
import com.example.batchMaster.repository.SessionRepository;
import com.example.batchMaster.service.AttendanceService;
import com.example.batchMaster.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AttendanceService attendanceService;


    @Autowired
    private AttendanceServiceImpl attendanceServiceImpl;

    @Override
    public Session createSession(SessionCreateRequest sessionCreateRequest) {
        if (sessionCreateRequest == null) {
            throw new IllegalArgumentException("Session request cannot be null");
        }

        Session session = new Session();
        session.setSubject(sessionCreateRequest.getSubject());
        session.setTopic(sessionCreateRequest.getTopic());
        session.setMentor(sessionCreateRequest.getMentor());
        session.setType(sessionCreateRequest.getType());
        session.setSessionLink(sessionCreateRequest.getSessionLink());
        session.setDate(new Date());
        session.setBatchId(sessionCreateRequest.getBatchId());
        session.setOnlineStudentsIds(sessionCreateRequest.getOnlineStudentsIds());
        session.setOfflineStudentsIds(sessionCreateRequest.getOfflineStudentsIds());
        session.setAbsentStudentsIds(sessionCreateRequest.getAbsentStudentsIds());
        session.setBranchId(sessionCreateRequest.getBranchId());
        session.setDay(sessionCreateRequest.getDay());
        session.setWeek(sessionCreateRequest.getWeek());
        session.setCreatedAt(Instant.now());

        // Save session first
        session = sessionRepository.save(session);

        // Process attendance
        processAttendance(sessionCreateRequest.getOnlineStudentsIds(), sessionCreateRequest, true, "online", session.getSessionId());
        processAttendance(sessionCreateRequest.getOfflineStudentsIds(), sessionCreateRequest, true, "offline", session.getSessionId());
        processAttendance(sessionCreateRequest.getAbsentStudentsIds(), sessionCreateRequest, false, "not present", session.getSessionId());

        return session;
    }

    private void processAttendance(List<String> studentIds, SessionCreateRequest request, boolean status, String mode, String sessionId) {
        for (String studentId : studentIds) {
            AttendanceCreateRequest attendanceRequest = new AttendanceCreateRequest();
            attendanceRequest.setStatus(status);
            attendanceRequest.setMode(mode); // Can be null for absent students
            attendanceRequest.setStudentId(studentId);
            attendanceRequest.setBatchId(request.getBatchId());
            attendanceRequest.setSessionId(sessionId);

            // Save attendance
            attendanceService.createAttendance(attendanceRequest);
        }
    }


    @Override
    public Session updateSession(SessionUpdateRequest updatedSession) {
        Optional<Session> existingSessionOpt = sessionRepository.findById(updatedSession.getSessionId());

        if (existingSessionOpt.isPresent()) {
            Session session = existingSessionOpt.get();
            session.setSubject(updatedSession.getSubject());
            session.setTopic(updatedSession.getTopic());
            session.setMentor(updatedSession.getMentor());
            session.setType(updatedSession.getType());
            session.setSessionLink(updatedSession.getSessionLink());
            session.setBatchId(updatedSession.getBatchId());
            session.setOnlineStudentsIds(updatedSession.getOnlineStudentsIds());
            session.setOfflineStudentsIds(updatedSession.getOfflineStudentsIds());
            session.setAbsentStudentsIds(updatedSession.getAbsentStudentsIds());
            session.setBranchId(updatedSession.getBranchId());
            session.setDay(updatedSession.getDay());
            session.setWeek(updatedSession.getWeek());
            session.setCreatedAt(Instant.now());

            // Save session first
            session = sessionRepository.save(session);

            // Process attendance
            UpdateAttendance(updatedSession.getOnlineStudentsIds(), updatedSession, true, "online", session.getSessionId());
            UpdateAttendance(updatedSession.getOfflineStudentsIds(), updatedSession, true, "offline", session.getSessionId());
            UpdateAttendance(updatedSession.getAbsentStudentsIds(), updatedSession, false, "not present", session.getSessionId());

            return session;
        }
        throw new RuntimeException("Session not found with ID: " + updatedSession.getBatchId());
    }

    private void UpdateAttendance(List<String> studentIds, SessionUpdateRequest request, boolean status, String mode, String sessionId) {
        for (String studentId : studentIds) {
            AttendanceCreateRequest attendanceRequest = new AttendanceCreateRequest();
            attendanceRequest.setStatus(status);
            attendanceRequest.setMode(mode); // Can be null for absent students
            
            attendanceRequest.setStudentId(studentId);
            attendanceRequest.setBatchId(request.getBatchId());
            attendanceRequest.setSessionId(sessionId);

            // Save attendance
            attendanceService.createAttendance(attendanceRequest);
        }
    }

    @Override
    public List<Session> getSessionsByBatchId(String batchId) {
        return sessionRepository.findAllByBatchId(batchId);
    }

    @Override
    public List<Session> getSessionsBySubject(String subject) {
        return sessionRepository.findAllBySubject(subject);
    }

    @Override
    public Session getSessionById(String sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(() -> new RuntimeException("Session not found with ID: " + sessionId));
    }

    @Override
    public boolean deleteSessionById(String sessionId) {
        if (sessionRepository.existsById(sessionId)) {
            sessionRepository.deleteById(sessionId);
            return true;
        } else {
            throw new RuntimeException("Session not found with ID: " + sessionId);
        }
    }

    @Override
    public Session getLastSessionByBatchId(String batchId) {
        return sessionRepository.findTopByBatchIdOrderByCreatedAtDesc(batchId)
                .orElseThrow(() -> new RuntimeException("No session found for batch ID: " + batchId));
    }

    @Override
    public List<Session> getAllSessionsOfAllBatchesByBranchId(String branch) {
        return sessionRepository.findAllByBranchId(branch);

    }

    @Override
    public List<Session> getAllSessionsOfAllBatchesBySubjectAndTopic(String subject, String topic) {
        return sessionRepository.findAllBySubjectAndTopic(subject, topic);

    }


    @Override
    public List<Session> getAllLastSessionsOfAllBatchesByBranchId(String branchId) {
        return sessionRepository.findLastSessionForEachBatchByBranchId(branchId);
    }

    @Override
    public List<Session> getSessionsByDate(String date) {
        return sessionRepository.findAllByDate(date);
    }

    @Override
    public List<Session> getAllSessionsByBatchIdAndSubject(String batchId, String subject) {
        return sessionRepository.findAllByBatchIdAndSubject(batchId, subject);
    }


}
