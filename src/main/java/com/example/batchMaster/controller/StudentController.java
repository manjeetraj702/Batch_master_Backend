package com.example.batchMaster.controller;

import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        return studentService.createStudent(studentCreateRequest);
    }

    // Get student details by ID
    @GetMapping("/{studentId}")
    public Student getStudentDetails(@RequestParam String studentId) {
        return studentService.getStudentDetails(studentId);
    }

    // Update student details
    @PutMapping
    public Student updateStudent(@RequestBody StudentUpdateRequest studentUpdateRequest) {
        return studentService.updateStudent(studentUpdateRequest);
    }

    // Change student status (active/inactive)
    @PatchMapping("/{studentId}/status")
    public Student changeStudentStatus(@RequestParam String studentId) {
        return studentService.changeStudentStatus(studentId);
    }

    // Get list of marks for a student
    @GetMapping("/{studentId}/marks")
    public List<String> getListOfMarks(@RequestParam String studentId) {
        return studentService.getListOfMarks(studentId);
    }

    // Get list of attendance records for a student
    @GetMapping("/{studentId}/attendance")
    public List<String> getListOfAttendance(@RequestParam String studentId) {
        return studentService.getListOfAttendance(studentId);
    }
}
