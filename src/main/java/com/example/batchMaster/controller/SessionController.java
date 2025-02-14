package com.example.batchMaster.controller;

import com.example.batchMaster.model.Session;
import com.example.batchMaster.model.request.SessionCreateRequest;
import com.example.batchMaster.model.updateRequest.SessionUpdateRequest;
import com.example.batchMaster.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/create")
    public Session createSession(@RequestBody SessionCreateRequest session) {
        return sessionService.createSession(session);
    }

    @PutMapping("/update/BySessionId")
    public Session updateSession(@RequestBody SessionUpdateRequest updatedSession) {
        return sessionService.updateSession(updatedSession);
    }

    @GetMapping("/batch/batchId")
    public List<Session> getSessionsByBatchId(@PathVariable String batchId) {
        return sessionService.getSessionsByBatchId(batchId);
    }

    @GetMapping("/subject/subject")
    public List<Session> getSessionsBySubject(@PathVariable String subject) {
        return sessionService.getSessionsBySubject(subject);
    }

    @GetMapping("/date/date")
    public List<Session> getSessionsByDate(@PathVariable String date) {
        return sessionService.getSessionsByDate(date);
    }


    @DeleteMapping("/delete/sessionId")
    public boolean deleteSession(@PathVariable String sessionId) {
        return sessionService.deleteSessionById(sessionId);
    }

    @GetMapping("/sessionId")
    public Session getSessionById(@PathVariable String sessionId) {
        return sessionService.getSessionById(sessionId);
    }

    @GetMapping("/last/batch/batchId")
    public Session getLastSessionByBatchId(@PathVariable String batchId) {
        return sessionService.getLastSessionByBatchId(batchId);
    }

    @GetMapping("/branch/branchId/lastSessions")
    public List<Session> getLastSessionForEachBatch(@PathVariable String branchId) {
        return sessionService.getAllLastSessionsOfAllBatchesByBranchId(branchId);
    }

    @GetMapping("/branch/branchId/sessions")
    public List<Session> getAllSessionsOfAllBatchesByBranchId(@PathVariable String branchId) {
        return sessionService.getAllSessionsOfAllBatchesByBranchId(branchId);
    }

    @GetMapping("/subject/subject/topic/topic")
    public List<Session> getAllSessionsOfAllBatchesBySubjectAndTopic(@PathVariable String subject, @PathVariable String topic) {
        return sessionService.getAllSessionsOfAllBatchesBySubjectAndTopic(subject, topic);
    }


}
