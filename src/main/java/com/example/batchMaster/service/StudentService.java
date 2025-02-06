package com.example.batchMaster.service;

import com.example.batchMaster.model.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student) ;

    public Student getStudentDetails(String studentId) ;

    public Student updateStudent(Student student) ;

    public Student changeStudentStatus(String studentId, boolean status) ;

    public List<String> getListOfMarks(String studentId) ;

    public List<String> getListOfAttendance(String studentId) ;
}