package com.example.batchMaster.service.impl;

import com.example.batchMaster.model.Student;
import com.example.batchMaster.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class StudentServiceImpl implements StudentService {


    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudentDetails(String studentId) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student changeStudentStatus(String studentId, boolean status) {
        return null;
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