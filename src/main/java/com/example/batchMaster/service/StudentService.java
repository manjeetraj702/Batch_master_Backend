package com.example.batchMaster.service;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
     Student createStudent(StudentCreateRequest studentCreateRequest) ;

     Student getStudentDetails(String studentId) ;

     Student updateStudent(StudentUpdateRequest studentUpdateRequest) ;

     Student changeStudentStatus(String studentId) ;

     List<Marks> getListOfMarks(String studentId) ;

     List<Attendance> getListOfAttendance(String studentId) ;

     Student getStudentById(String studentId);

     List<Student> getStudentsByBatchId(String batchId);
}

