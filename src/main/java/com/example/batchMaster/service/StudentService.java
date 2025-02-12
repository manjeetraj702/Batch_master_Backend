package com.example.batchMaster.service;

import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentCreateRequest studentCreateRequest);

    Student getStudentDetails(String studentId);

    Student updateStudent(StudentUpdateRequest studentUpdateRequest);

    Student changeStudentStatus(String studentId);

    List<Marks> getListOfMarks(String studentId);

    Student getStudentById(String studentId);

    Student updateStudentBatchId(String studentId, String batchId);

    Student removeStudentFromBatch(String studentId);

    List<Student> getStudentsByBatchId(String batchId);

    List<Student> getOnlineStudents(String batchId);

    List<Student> getOfflineStudents(String batchId);

    List<Student> getStudentsByBranch(String branchId);
}

