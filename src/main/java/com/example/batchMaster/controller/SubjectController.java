package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Create a new subject
    @PostMapping("/create")
    public ApiResponse<Subject> createSubject(@RequestParam String subjectName, @RequestParam List<String> topics) {
        Subject subject = subjectService.createNewSubject(subjectName, topics);
        return new ApiResponse<>(subject, HttpStatus.CREATED);
    }

    // Update subject details
    @PutMapping("/update")
    public ApiResponse<Subject> updateSubject(@RequestParam String subjectId, @RequestParam String newName, @RequestParam List<String> topics) {
        Subject subject = subjectService.updateSubject(subjectId, newName, topics);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    // Get subject details by ID
    @GetMapping("/getSubjectById")
    public ApiResponse<Subject> getSubjectById(@RequestParam String subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    // Delete a subject
    @DeleteMapping("/deleteSubject")
    public ApiResponse<Boolean> deleteSubject(@RequestParam String subjectId) {
        Boolean deleted = subjectService.deleteSubject(subjectId);
        return new ApiResponse<>(deleted, HttpStatus.OK);
    }

    // Get all subjects
    @GetMapping("/getAllSubjects")
    public ApiResponse<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ApiResponse<>(subjects, HttpStatus.OK);
    }


    // add topic in subject
    @PutMapping("/addTopicBySubjectId")
    public ApiResponse<Subject> addTopicBySubjectId(String subjectId, String topic) {
        Subject subject = subjectService.addTopicsInSubject(subjectId, topic);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }

    // remove topic from subject
    @PutMapping("/removeTopicsFromSubject")
    public ApiResponse<Subject> removeTopicsFromSubject(String subjectId, String topic) {
        Subject subject = subjectService.removeTopicsFromSubject(subjectId, topic);
        return new ApiResponse<>(subject, HttpStatus.OK);
    }
}
