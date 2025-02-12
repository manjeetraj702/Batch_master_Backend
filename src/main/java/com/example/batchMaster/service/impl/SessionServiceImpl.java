package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.AttendanceCreateRequest;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;
import com.example.batchMaster.repository.SessionRepository;
import com.example.batchMaster.service.AttendanceService;
import com.example.batchMaster.service.SessionService;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private StudentService studentService;

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
        session.setSessionLink(sessionCreateRequest.getSessionLink());
        session.setDate(sessionCreateRequest.getDate());
        session.setBatchId(sessionCreateRequest.getBatchId());
        if (sessionCreateRequest.getOnlineStudentsIds() != null) {
            if (session.getOnlineStudents() == null) {
                session.setOnlineStudents(sessionCreateRequest.getOnlineStudentsIds());
            } else {
                session.getOnlineStudents().addAll(sessionCreateRequest.getOnlineStudentsIds());
            }
        }
        if (sessionCreateRequest.getOfflineStudentsIds() != null) {
            if (session.getOfflineStudents() == null) {
                session.setOfflineStudents(sessionCreateRequest.getOfflineStudentsIds());
            } else {
                session.getOfflineStudents().addAll(sessionCreateRequest.getOfflineStudentsIds());
            }
        }
        List<String> presentStudents = session.getPresentStudentsId();
        if (presentStudents != null) {
            for (String presentStudentId : presentStudents) {
                AttendanceCreateRequest attendanceCreateRequest = new AttendanceCreateRequest();
                attendanceCreateRequest.setStudentId(presentStudentId);
                attendanceCreateRequest.setBatchId(session.getBatchId());
                attendanceCreateRequest.setDate(session.getDate());
                attendanceCreateRequest.setStatus(true);
              attendanceService.createAttendance(attendanceCreateRequest);
            }
        }
        List<String> absentStudents = session.getAbsentStudentsId();
        if (absentStudents != null) {
            for (String absentStudentId : absentStudents) {
                AttendanceCreateRequest attendanceCreateRequest = new AttendanceCreateRequest();
                attendanceCreateRequest.setStudentId(absentStudentId);
                attendanceCreateRequest.setBatchId(session.getBatchId());
                attendanceCreateRequest.setDate(session.getDate());
                attendanceCreateRequest.setStatus(false);
                attendanceService.createAttendance(attendanceCreateRequest);
            }
        }
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(SessionUpdateRequest updatedSession) {
        Optional<Session> existingSessionOpt = sessionRepository.findById(updatedSession.getBatchId());
        if (existingSessionOpt.isPresent()) {
            Session existingSession = existingSessionOpt.get();
            existingSession.setSubject(updatedSession.getSubject());
            existingSession.setTopic(updatedSession.getTopic());
            existingSession.setMentor(updatedSession.getMentor());
            existingSession.setSessionLink(updatedSession.getSessionLink());
            existingSession.setDate(updatedSession.getDate());
            existingSession.setBatchId(updatedSession.getBatchId());
            if (updatedSession.getOnlineStudentsIds() != null) {
                if (existingSession.getOnlineStudents() == null) {
                    existingSession.setOnlineStudents(updatedSession.getOnlineStudentsIds());
                } else {
                    existingSession.getOnlineStudents().addAll(updatedSession.getOnlineStudentsIds());
                }
            }
            if (updatedSession.getOfflineStudentsIds() != null) {
                if (existingSession.getOfflineStudents() == null) {
                    existingSession.setOfflineStudents(updatedSession.getOfflineStudentsIds());
                } else {
                    existingSession.getOfflineStudents().addAll(updatedSession.getOfflineStudentsIds());
                }
            }
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
        Optional<Session> session = sessionRepository.findTopByBatchIdOrderByCreatedAtDesc(batchId);
        if (session.isPresent()) {
            return session.get();
        } else {
            throw new RuntimeException("No session found for batch ID: " + batchId);
        }
    }

    @Override
    public Session addStudentsToSession(String sessionId, List<String> onlineStudents, List<String> offlineStudents) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(() -> new RuntimeException("Session not found with ID: " + sessionId));
        if (onlineStudents != null) {
            if (session.getOnlineStudents() == null) {
                session.setOnlineStudents(onlineStudents);
            } else {
                session.getOnlineStudents().addAll(onlineStudents);
            }
        }
        if (offlineStudents != null) {
            if (session.getOfflineStudents() == null) {
                session.setOfflineStudents(offlineStudents);
            } else {
                session.getOfflineStudents().addAll(offlineStudents);
            }
        }
        return sessionRepository.save(session);
    }


}
