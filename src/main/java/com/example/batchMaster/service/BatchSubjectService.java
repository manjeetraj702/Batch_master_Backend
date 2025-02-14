package com.example.batchMaster.service;


import com.example.batchMaster.model.BatchSubject;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;

import java.util.List;

public interface BatchSubjectService {

    BatchSubject createCourse(SubjectCreateRequest subjectCreateRequest);

    BatchSubject updateSubject(SubjectUpdateRequest subjectUpdateRequest);

    BatchSubject getSubjectById(String SubjectId);

    BatchSubject changeSubjectStatus(String SubjectId);

    List<BatchSubject> getAllSubject();

    List<BatchSubject> getSubjectByBatchId(String batchId);


    BatchSubject getBySubjectNameAndBatchId(String subjectName, String batchId);

    List<BatchSubject> getCompleteSubject(String batchId);

    List<BatchSubject> getIncompleteSubject(String batchId);

}
