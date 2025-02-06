package com.example.batchMaster.controller;

import com.example.first.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
    @Autowired
    private Subjectservice subjectservice;
    @PostMapping("/create")
    public Subject createCourse(@RequestBody SubjectCreateRequest subjectCreateRequest)
    {
        return subjectservice.createCourse(subjectCreateRequest);
    }

}
