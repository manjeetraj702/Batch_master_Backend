package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.BatchSubject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.BatchSubjectUpdateRequest;
import com.example.batchMaster.service.BatchSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/batchSubject")
public class BatchSubjectController {

    private final BatchSubjectService batchSubjectService;

    @Autowired
    public BatchSubjectController(BatchSubjectService batchSubjectService) {
        this.batchSubjectService = batchSubjectService;
    }

    // Create a new subject in a batch
    @PostMapping("/create")
    public ApiResponse<BatchSubject> createBatchSubject(@RequestBody SubjectCreateRequest subjectCreateRequest) {
        BatchSubject subject = batchSubjectService.createCourse(subjectCreateRequest);
        return new ApiResponse<>(subject, HttpStatus.CREATED);
    }

    // Update an existing subject
    @PutMapping("/update")
    public ApiResponse<BatchSubject> updateSubject(@RequestBody BatchSubjectUpdateRequest subjectUpdateRequest) {
        BatchSubject subject = batchSubjectService.updateSubject(subjectUpdateRequest);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    // Get all subjects
    @GetMapping("/getAllSubjects")
    public ApiResponse<List<BatchSubject>> getAllSubjects() {
        List<BatchSubject> subjects = batchSubjectService.getAllSubject();
        return new ApiResponse<>(subjects, HttpStatus.OK);
    }

    // Change subject status (active/inactive)
    @PatchMapping("/changeSubjectStatus")
    public ApiResponse<BatchSubject> changeSubjectStatus(@RequestParam(name = "subjectId") String subjectId) {
        BatchSubject subject = batchSubjectService.changeSubjectStatus(subjectId);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    // Get incomplete subjects by batch ID
    @GetMapping("/getIncompleteSubjects")
    public ApiResponse<List<BatchSubject>> getIncompleteSubjects(@RequestParam(name = "batchId") String batchId) {
        List<BatchSubject> subjects = batchSubjectService.getIncompleteSubject(batchId);
        return new ApiResponse<>(subjects, HttpStatus.OK);
    }

    // Get complete subjects by batch ID
    @GetMapping("/getCompleteSubjects")
    public ApiResponse<List<BatchSubject>> getCompleteSubjects(@RequestParam(name = "batchId") String batchId) {
        List<BatchSubject> subjects = batchSubjectService.getCompleteSubject(batchId);
        return new ApiResponse<>(subjects, HttpStatus.OK);
    }

    // Get subjects by batch ID
    @GetMapping("/getSubjectsByBatchId")
    public ApiResponse<List<BatchSubject>> getSubjectsByBatchId(@RequestParam(name = "batchId") String batchId) {
        List<BatchSubject> subjects = batchSubjectService.getSubjectByBatchId(batchId);
        return new ApiResponse<>(subjects, HttpStatus.OK);
    }

    // Get subject by name and batch ID
    @GetMapping("/getBySubjectNameAndBatchId")
    public ApiResponse<BatchSubject> getBySubjectNameAndBatchId(
            @RequestParam(name = "subjectName") String subjectName,
            @RequestParam(name = "batchId") String batchId) {
        BatchSubject subject = batchSubjectService.getBySubjectNameAndBatchId(subjectName, batchId);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    @PutMapping("/add-topicBySubjectId")
    public ApiResponse<BatchSubject> addTopic(@RequestParam String subjectId, @RequestParam String topic) {
        BatchSubject updatedSubject = batchSubjectService.addTopic(subjectId, topic);
        return new ApiResponse<>(updatedSubject, HttpStatus.OK);
    }

    @PutMapping("/remove-topicBySubjectId")
    public ApiResponse<BatchSubject> removeTopic(@RequestParam String subjectId, @RequestParam String topic) {
        BatchSubject updatedSubject = batchSubjectService.removeTopic(subjectId, topic);
        return new ApiResponse<>(updatedSubject, HttpStatus.OK);
    }
}
