package com.example.batchMaster.service;

import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;

import java.util.List;

public interface StudentService {
    public Student createStudent(StudentCreateRequest studentCreateRequest) ;

    public Student getStudentDetails(String studentId) ;

    public Student updateStudent(Student student) ;

    public Student changeStudentStatus(String studentId) ;

    public List<String> getListOfMarks(String studentId) ;

    public List<String> getListOfAttendance(String studentId) ;
}