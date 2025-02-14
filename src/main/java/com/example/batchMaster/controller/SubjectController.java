package com.example.batchMaster.controller;

import com.example.batchMaster.model.Subject;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping("/createSubject")
    public Subject createNewSubject(@RequestParam String subjectName, @RequestParam List<String> listOfTopics) {
        return subjectService.createNewSubject(subjectName, listOfTopics);
    }
    @PutMapping("/updateSubject")
    public Subject updateSubject(@RequestParam String subjectId, @RequestParam String subjectNewName, @RequestParam List<String> listofTopics) {
        return subjectService.updateSubject(subjectId, subjectNewName, listofTopics);
    }

    @GetMapping("/getSubjectById")
    public Subject getSubjectById(@RequestParam String subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @DeleteMapping("/deleteSubject")
    public Boolean deleteStudent(@RequestParam String subjectId) {
        return subjectService.deleteSubject(subjectId);
    }

    @GetMapping("/getAllSubjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
