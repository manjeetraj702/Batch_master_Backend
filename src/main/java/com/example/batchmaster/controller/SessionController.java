package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Session;
import com.example.batchmaster.model.request.SessionCreateRequest;
import com.example.batchmaster.model.updaterequest.SessionUpdateRequest;
import com.example.batchmaster.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Create a new session
    @PostMapping("/createSession")
    public ApiResponse<Session> createSession(@RequestBody SessionCreateRequest session) {
        Session createdSession = sessionService.createSession(session);
        return new ApiResponse<>(createdSession, HttpStatus.ACCEPTED);
    }

    // Update session
    @PutMapping("/updateSession")
    public ApiResponse<Session> updateSession(@RequestBody SessionUpdateRequest updatedSession) {
        Session session = sessionService.updateSession(updatedSession);
        return new ApiResponse<>(session, HttpStatus.OK);
    }

    // Get sessions by batch ID
    @GetMapping("/getSessionsByBatchId")
    public ApiResponse<List<Session>> getSessionsByBatchId(@RequestParam String batchId) {
        List<Session> sessions = sessionService.getSessionsByBatchId(batchId);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Get sessions by subject
    @GetMapping("/getSessionsBySubject")
    public ApiResponse<List<Session>> getSessionsBySubject(@RequestParam String subject) {
        List<Session> sessions = sessionService.getSessionsBySubject(subject);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Get sessions by date
    @GetMapping("/getSessionsByDate")
    public ApiResponse<List<Session>> getSessionsByDate(@RequestParam String date) {
        List<Session> sessions = sessionService.getSessionsByDate(date);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Delete a session by ID
    @DeleteMapping("/deleteSession")
    public ApiResponse<Boolean> deleteSession(@RequestParam String sessionId) {
        Boolean deleted = sessionService.deleteSessionById(sessionId);
        return new ApiResponse<>(deleted, HttpStatus.OK);
    }

    // Get a session by ID
    @GetMapping("/getSessionById")
    public ApiResponse<Session> getSessionById(@RequestParam String sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        return new ApiResponse<>(session, HttpStatus.OK);
    }

    // Get last session by batch ID
    @GetMapping("/getLastSessionByBatchId")
    public ApiResponse<Session> getLastSessionByBatchId(@RequestParam String batchId) {
        Session session = sessionService.getLastSessionByBatchId(batchId);
        return new ApiResponse<>(session, HttpStatus.OK);
    }

    // Get last session for each batch by branch ID
    @GetMapping("/getLastSessionForEachBatch")
    public ApiResponse<List<Session>> getLastSessionForEachBatch(@RequestParam String branchId) {
        List<Session> sessions = sessionService.getAllLastSessionsOfAllBatchesByBranchId(branchId);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Get all sessions of all batches by branch ID
    @GetMapping("/getAllSessionsOfAllBatchesByBranchId")
    public ApiResponse<List<Session>> getAllSessionsOfAllBatchesByBranchId(@RequestParam String branchId) {
        List<Session> sessions = sessionService.getAllSessionsOfAllBatchesByBranchId(branchId);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Get all sessions by subject and topic
    @GetMapping("/getAllSessionsOfAllBatchesBySubjectAndTopic")
    public ApiResponse<List<Session>> getAllSessionsOfAllBatchesBySubjectAndTopic(
            @RequestParam String subject, @RequestParam String topic) {
        List<Session> sessions = sessionService.getAllSessionsOfAllBatchesBySubjectAndTopic(subject, topic);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }

    // Get all sessions by batchId and subject
    @GetMapping("/getAllSessionsByBatchAndSubject")
    public ApiResponse<List<Session>> getAllSessionsOfAllBatchesByBatchIdAndSubject(
            @RequestParam String batchId, @RequestParam String subject) {
        List<Session> sessions = sessionService.getAllSessionsByBatchIdAndSubject(batchId, subject);
        return new ApiResponse<>(sessions, HttpStatus.OK);
    }


}
