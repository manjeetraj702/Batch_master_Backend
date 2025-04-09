package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Session;
import com.example.batchmaster.model.request.AttendanceCreateRequest;
import com.example.batchmaster.model.request.SessionCreateRequest;
import com.example.batchmaster.model.updaterequest.SessionUpdateRequest;
import com.example.batchmaster.repository.SessionRepository;
import com.example.batchmaster.service.AttendanceService;
import com.example.batchmaster.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final AttendanceService attendanceService;

    public SessionServiceImpl(SessionRepository sessionRepository, AttendanceService attendanceService) {
        this.sessionRepository = sessionRepository;
        this.attendanceService = attendanceService;
    }

    @Override
    @Transactional
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
        session.setDate(Instant.now());
        session.setBranchId(sessionCreateRequest.getBranchId());
        session.setBatchId(sessionCreateRequest.getBatchId());
        session.setOnlineStudentsIds(sessionCreateRequest.getOnlineStudentsIds());
        session.setOfflineStudentsIds(sessionCreateRequest.getOfflineStudentsIds());
        session.setAbsentStudentsIds(sessionCreateRequest.getAbsentStudentsIds());
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

    private void processAttendance(Set<String> studentIds, SessionCreateRequest request, boolean status, String mode, String sessionId) {

        if (studentIds == null || studentIds.isEmpty()) {
            return;
        }

        for (String studentId : studentIds) {
            log.info("Processing attendance for student: " + studentId);
            AttendanceCreateRequest attendanceRequest = new AttendanceCreateRequest();
            attendanceRequest.setStatus(status);
            attendanceRequest.setMode(mode);
            attendanceRequest.setStudentId(studentId);
            attendanceRequest.setBatchId(request.getBatchId());
            attendanceRequest.setSubject(request.getSubject());
            attendanceRequest.setSessionId(sessionId);
            attendanceRequest.setBranchId(request.getBranchId());
            attendanceRequest.setDate(Instant.now());

            attendanceService.createAttendance(attendanceRequest);
        }
    }


    @Override
    @Transactional
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
            updateAttendance(updatedSession.getOnlineStudentsIds(), updatedSession, true, "online", session.getSessionId());
            updateAttendance(updatedSession.getOfflineStudentsIds(), updatedSession, true, "offline", session.getSessionId());
            updateAttendance(updatedSession.getAbsentStudentsIds(), updatedSession, false, "not present", session.getSessionId());

            return session;
        }
        throw new BatchMasterException("Session not found with ID: " + updatedSession.getBatchId());
    }

    private void updateAttendance(Set<String> studentIds, SessionUpdateRequest request, boolean status, String mode, String sessionId) {

        if (studentIds == null || studentIds.isEmpty()) {
            return;
        }
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new BatchMasterException("Session not found with ID: " + sessionId));

        // Delete existing attendance entries for this session
        attendanceService.deleteAttendanceBySessionId(sessionId);

        for (String studentId : studentIds) {
            AttendanceCreateRequest attendanceRequest = new AttendanceCreateRequest();
            attendanceRequest.setDate(session.getDate());
            attendanceRequest.setStatus(status);
            attendanceRequest.setMode(mode);
            attendanceRequest.setSubject(request.getSubject());
            attendanceRequest.setStudentId(studentId);
            attendanceRequest.setBranchId(request.getBranchId());
            attendanceRequest.setBatchId(request.getBatchId());
            attendanceRequest.setSessionId(sessionId);

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
            throw new BatchMasterException("Session not found with ID: " + sessionId);
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
    public List<Session> getSessionsByDate(Date date) {
        return sessionRepository.findAllByDate(date);
    }

    @Override
    public List<Session> getAllSessionsByBatchIdAndSubject(String batchId, String subject) {
        return sessionRepository.findAllByBatchIdAndSubject(batchId, subject);
    }

    @Override
    public List<Session> getSessionsByBatchIdAndDate(String batchId, Date date) {
        return sessionRepository.findAllByBatchIdAndDate(batchId, date);
    }

    @Override
    public List<Session> getSessionsByBatchIdAndDateAfter(String batchId, Date fromDate) {
        return sessionRepository.findAllByBatchIdAndDateAfter(batchId, fromDate);
    }

    @Override
    public List<Session> getSessionsByBatchIdAndDateBefore(String batchId, Date toDate) {
        return sessionRepository.findAllByBatchIdAndDateBefore(batchId, toDate);
    }

    @Override
    public List<Session> getSessionsByBatchIdAndDateBetween(String batchId, Date startDate, Date endDate) {
        return sessionRepository.findAllByBatchIdAndDateBetween(batchId, startDate, endDate);
    }

    @Override
    public List<Session> getSessionsByDateAfter(Date fromDate) {
        return sessionRepository.findAllByDateAfter(fromDate);
    }

    @Override
    public List<Session> getSessionsByDateBefore(Date toDate) {
        return sessionRepository.findAllByDateBefore(toDate);
    }

    @Override
    public List<Session> getSessionsByDateBetween(Date startDate, Date endDate) {
        return sessionRepository.findAllByDateBetween(startDate, endDate);
    }


}
