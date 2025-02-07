package com.example.batchMaster.service;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;

import java.util.List;

public interface BatchService {
    String createBatch(Batch batch);

    String updateBatch(String batchId, Batch updatedBatch);

    String addStudent(String batchId, String studentId);

    String removeStudent(String batchId, String studentId);

    List<Student> getListOfStudents(String batchId);

    List<Subject> getListOfCompletedSubjects(String batchId);

    List<Subject> getListOfInCompletedSubjects(String batchId);

    List<Subject> getListOfCurrentSubjects(String batchId);

    List<Student> getListOfOnlineStudents(String batchId);

    List<Student> getListOfOfflineStudents(String batchId);

    String getListOfTestResults(String batchId);

    String updateBatchStatus(String batchId);
}
