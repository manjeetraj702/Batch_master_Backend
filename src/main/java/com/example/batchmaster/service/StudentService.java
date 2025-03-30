package com.example.batchmaster.service;

import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.Student;
import com.example.batchmaster.model.request.StudentCreateRequest;
import com.example.batchmaster.model.updaterequest.StudentUpdateRequest;

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

    List<Student> getStudentsByBranchId(String branchId);

    List<Student> getAllStudents();

    Student getStudentByEmailId(String emailId);

    boolean updateStudentImage(String studentId, String imgUrl);
}

