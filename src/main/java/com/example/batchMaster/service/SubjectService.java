package com.example.batchMaster.service;

import com.example.batchMaster.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject createNewSubject(String subjectName, List<String> listOfTopics);

    Subject updateSubject(String subjectId, String subjectNewName, List<String> listofTopics);

    Subject getSubjectById(String subjectId);

    Boolean deleteSubject(String subjectId);

    List<Subject> getAllSubjects();
}
