package com.example.batchMaster.service;


import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;

public interface SubjectService {

    Subject createCourse(SubjectCreateRequest subjectCreateRequest);
    Subject updateSubject(SubjectUpdateRequest subjectUpdateRequest);

   public   Subject getSubjectById(String SubjectId);


}
