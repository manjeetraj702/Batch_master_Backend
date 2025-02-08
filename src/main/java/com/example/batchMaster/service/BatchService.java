package com.example.batchMaster.service;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;

import java.util.List;

public interface BatchService {
    Batch createBatch(Batch batch);

    Batch updateBatch(String batchId, Batch updatedBatch);

    Batch updateBatchStatus(String batchId);

    Batch addStudent(String batchId, String studentId);

    Batch removeStudent(String batchId, String studentId);

    List<Student> getListOfStudents(String batchId);

    List<Subject> getListOfCompletedSubjects(String batchId);

    List<Subject> getListOfInCompletedSubjects(String batchId);

    List<Subject> getListOfCurrentSubjects(String batchId);

    List<Student> getListOfOnlineStudents(String batchId);

    List<Student> getListOfOfflineStudents(String batchId);

    List<Result> getListOfTestResults(String batchId);

    Result getTestResultsofSubjectofTopic(String batchId,String subject,String topic);

    List<Result> getListOfTestResultofSubject(String batchId, String subject);
}
