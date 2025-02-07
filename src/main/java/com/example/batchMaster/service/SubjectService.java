package com.example.batchMaster.service;


import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;

import java.util.List;

public interface SubjectService {

    Subject createCourse(SubjectCreateRequest subjectCreateRequest);
    Subject updateSubject(SubjectUpdateRequest subjectUpdateRequest);

     Subject getSubjectById(String SubjectId);
     Subject changeSubjectStatus(String SubjectId);
   List<Subject> getAllSubject();
   List<Subject> getbyBatchId(String batchId);

}
