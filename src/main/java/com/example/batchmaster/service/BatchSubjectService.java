package com.example.batchmaster.service;


import com.example.batchmaster.model.BatchSubject;
import com.example.batchmaster.model.request.SubjectCreateRequest;
import com.example.batchmaster.model.updaterequest.BatchSubjectUpdateRequest;

import java.util.List;

public interface BatchSubjectService {

    BatchSubject createCourse(SubjectCreateRequest subjectCreateRequest);

    BatchSubject updateSubject(BatchSubjectUpdateRequest subjectUpdateRequest);

    BatchSubject getSubjectById(String SubjectId);

    BatchSubject changeSubjectStatus(String SubjectId);

    List<BatchSubject> getAllSubject();

    List<BatchSubject> getSubjectByBatchId(String batchId);


    BatchSubject getBySubjectNameAndBatchId(String subjectName, String batchId);

    List<BatchSubject> getCompleteSubject(String batchId);

    List<BatchSubject> getIncompleteSubject(String batchId);

    BatchSubject addTopic(String subjectId, String topic);

    BatchSubject removeTopic(String subjectId, String topic);

}
