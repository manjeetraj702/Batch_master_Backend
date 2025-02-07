package com.example.batchMaster.service;


import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;

public interface SubjectService {

    Subject createCourse(SubjectCreateRequest subjectCreateRequest);
}
