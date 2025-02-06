package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.repository.StudentRepository;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        return null;
    }

    @Override
    public Student getStudentDetails(String studentId) {
        return new Student();
    }

    @Override
    public Student updateStudent(Student student) {
        return new Student();
    }

    @Override
    public Student changeStudentStatus(String studentId) {
        return new Student();
    }

    @Override
    public List<String> getListOfMarks(String studentId) {
        return List.of();
    }

    @Override
    public List<String> getListOfAttendance(String studentId) {
        return List.of();
    }
}