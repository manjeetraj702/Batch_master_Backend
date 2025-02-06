package com.example.batchMaster.service.impl;

import com.example.first.model.CreateRequest.SubjectCreateRequest;
import com.example.first.model.Subject;
import com.example.first.repository.SubjectRepository;
import com.example.first.service.Subjectservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Subjectserivceimpl implements Subjectservice {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject createCourse(SubjectCreateRequest subjectCreateRequest) {

           Subject subject = new Subject();
          subject.setSubjectName(subjectCreateRequest.getSubjectName());
          subject.setBatchId(subjectCreateRequest.getBatchId());
          subject.setStatus(subjectCreateRequest.getStatus());
              return subjectRepository.save(subject);


    }


}
