package com.example.batchMaster.service;

import com.example.batchMaster.model.*;

import java.util.List;

public interface BatchService {
//    BATCH
    Batch createBatch(Batch batch);

    Batch updateBatch(String batchId, Batch updatedBatch);

    Batch updateBatchStatus(String batchId);

//   STUDENT
    Batch addStudent(String batchId, String studentId);

    Batch removeStudent(String batchId, String studentId);

    List<Student> getListOfStudents(String batchId);

    List<Student> getListOfOnlineStudents(String batchId);

    List<Student> getListOfOfflineStudents(String batchId);

//    SUBJECT
    List<Subject> getListOfCompletedSubjects(String batchId);

    List<Subject> getListOfInCompletedSubjects(String batchId);

    Subject getCompletedSubjectTopics(String batchId, String subject);

    List<Subject> getListOfCurrentSubjects(String batchId);

//    TEST RESULT
    List<Result> getListOfTestResults(String batchId);

    Result getTestResultsofSubjectofTopic(String batchId,String subject,String topic);

    List<Result> getListOfTestResultofSubject(String batchId, String subject);



//    ATTENDANCE
    List<Attendance> getAllStudentAttendanceByBatchId(String batchId);

    List<Attendance> getAttendanceByBatchIdAndDate(String batchId, String date);


}
