package com.example.batchMaster.service.impl;


import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.repository.SubjectRepository;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectServiceImpl implements SubjectService {
@Autowired
private SubjectRepository subjectRepository ;

    @Override
    public Subject createCourse(SubjectCreateRequest subjectCreateRequest) {
     Subject subject = new Subject() ;
     subject.setSubjectId(subjectCreateRequest.getSubjectId());
     subject.setSubjectName(subjectCreateRequest.getSubjectName());
     subject.setBatchId(subjectCreateRequest.getBatchId());
     subject.setStatus(subjectCreateRequest.getStatus());
     subject.setListOfTopics(subjectCreateRequest.getListOfTopics());
        return subjectRepository.save(subject);
    }
}
