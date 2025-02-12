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

    @PutMapping("/update/{sessionId}")
    public Session updateSession( @RequestBody SessionUpdateRequest updatedSession) {
        return sessionService.updateSession( updatedSession);
    }

    @GetMapping("/batch/{batchId}")
    public List<Session> getSessionsByBatchId(@RequestParam String batchId) {
        return sessionService.getSessionsByBatchId(batchId);
    }

    @GetMapping("/subject/{subject}")
    public List<Session> getSessionsBySubject(@RequestParam String subject) {
        return sessionService.getSessionsBySubject(subject);
    }

    @DeleteMapping("/delete/{sessionId}")
    public boolean  deleteSession(@RequestParam String sessionId) {
        return sessionService.deleteSessionById(sessionId);
    }

    @GetMapping("/sessionId")
    public Session getSessionById(@RequestParam String sessionId) {
        return sessionService.getSessionById(sessionId);
    }

    @GetMapping("/sessionByBatchId")
    public List<Session> getAllSessions(@RequestParam String batchId) {
        return sessionService.getSessionsByBatchId(batchId);
    }


    @GetMapping("/sessions/last/batchId")
    public Session getLastSessionByBatchId( @RequestParam String batchId)
    {
        return sessionService.getLastSessionByBatchId(batchId);
    }


    @GetMapping("/branchId/lastSessions")
    public List<Session> getLastSessionForEachBatch(@RequestParam String branchId) {
        return sessionService.getAllLastSessionsOfAllBatchesByBranchId(branchId);
    }
}
