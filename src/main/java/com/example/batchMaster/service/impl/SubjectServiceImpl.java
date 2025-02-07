package com.example.batchMaster.service.impl;


import com.example.batchMaster.exception.BatchMasterException;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.model.request.SubjectCreateRequest;
import com.example.batchMaster.model.updateRequest.SubjectUpdateRequest;
import com.example.batchMaster.repository.SubjectRepository;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
@Autowired
private SubjectRepository subjectRepository ;

    @Override
    public Subject createCourse(SubjectCreateRequest subjectCreateRequest) {
     Subject subject = new Subject() ;
     subject.setSubjectName(subjectCreateRequest.getSubjectName());
     subject.setBatchId(subjectCreateRequest.getBatchId());
     subject.setStatus(subjectCreateRequest.isStatus());
     subject.setListOfTopics(subjectCreateRequest.getListOfTopics());
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(SubjectUpdateRequest subjectUpdateRequest) {
        getSubjectById(subjectUpdateRequest.getSubjectId());
        Subject subject = new Subject() ;
        subject.setSubjectId(subjectUpdateRequest.getSubjectId());
         subject.setSubjectName(subjectUpdateRequest.getSubjectName());
         subject.setBatchId(subjectUpdateRequest.getBatchId());
         subject.setListOfTopics(subjectUpdateRequest.getListOfTopics());
         subject.setStatus(subjectUpdateRequest.isStatus());
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectById(String SubjectId) {
        Optional<Subject> subject= subjectRepository.findById(SubjectId);
        if(subject.isPresent())
        {
            return subject.get();
        }

        throw  new BatchMasterException("Subject is not present");
    }

    @Override
    public Subject changeSubjectStatus(String SubjectId) {
        Subject subject = getSubjectById(SubjectId);
        subject.setStatus(!subject.isStatus());

        return subjectRepository.save(subject);
    }


    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> getbyBatchId(String batchId) {
        return subjectRepository.findAllByBatchId(batchId);
    }

}
