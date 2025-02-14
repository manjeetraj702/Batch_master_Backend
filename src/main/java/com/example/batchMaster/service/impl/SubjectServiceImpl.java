package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Subject;
import com.example.batchMaster.repository.SubjectRepository;
import com.example.batchMaster.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject createNewSubject(String subjectName, List<String> listOfTopics) {
        Optional<Subject> subject = subjectRepository.findBySubjectName(subjectName);
        if(subject.isPresent()) {
            throw new RuntimeException("Subject already available with same name.");
        }
        Subject newSubject = new Subject();
        newSubject.setSubjectName(subjectName);
        newSubject.setListOfTopics(listOfTopics);

        return subjectRepository.save(newSubject);
    }

    @Override
    public Subject updateSubject(String subjectId, String subjectNewName, List<String> listOfTopics) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if (subject.isPresent()) {
            Subject subject1 = subject.get();
            subject1.setSubjectName(subjectNewName);
            subject1.setListOfTopics(listOfTopics);
            return subjectRepository.save(subject1);
        } else {
            throw new RuntimeException("Subject not found");
        }
    }


    @Override
    public Subject getSubjectById(String subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if(subject.isPresent()) {
            return subject.get();
        }
        throw new RuntimeException("Subject not found");
    }

    @Override
    public Boolean deleteSubject(String subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if(subject.isPresent()){
            subjectRepository.delete(subject.get());
            return true;
        }
        throw new RuntimeException("Subject not found");
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
