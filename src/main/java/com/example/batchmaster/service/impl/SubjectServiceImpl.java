package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.Subject;
import com.example.batchmaster.repository.SubjectRepository;
import com.example.batchmaster.service.SubjectService;
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
        if (subject.isPresent()) {
            throw new BatchMasterException("Subject already available with same name.");
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
            throw new BatchMasterException("Subject not found");
        }
    }


    @Override
    public Subject getSubjectById(String subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(() -> new BatchMasterException("Student with this Id not present"));
    }

    @Override
    public Boolean deleteSubject(String subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if (subject.isPresent()) {
            subjectRepository.delete(subject.get());
            return true;
        }
        throw new BatchMasterException("Subject not found");
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject addTopicsInSubject(String subjectId, String topic) {
        Subject subject = getSubjectById(subjectId);
        subject.getListOfTopics().add(topic);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject removeTopicsFromSubject(String subjectId, String topic) {
        Subject subject = getSubjectById(subjectId);
        subject.getListOfTopics().remove(topic);
        return subjectRepository.save(subject);
    }
}
