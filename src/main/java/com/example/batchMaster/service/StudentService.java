package com.example.batchMaster.service;

import com.example.batchMaster.model.Attendance;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    public Student createStudent(StudentCreateRequest studentCreateRequest) ;

    public Student getStudentDetails(String studentId) ;

    public Student updateStudent(StudentUpdateRequest studentUpdateRequest) ;

    public Student changeStudentStatus(String studentId) ;

    public List<Marks> getListOfMarks(String studentId) ;

    public List<Attendance> getListOfAttendance(String studentId) ;

    public Student getStudentById(String studentId);
}