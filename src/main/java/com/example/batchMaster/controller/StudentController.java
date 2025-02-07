package com.example.batchMaster.controller;

import com.example.batchMaster.model.Student;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Get student details by ID
    @GetMapping("/{studentId}")
    public Student getStudentDetails(@PathVariable String studentId) {
        return studentService.getStudentDetails(studentId);
    }

    // Update student details
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    // Change student status (active/inactive)
    @PatchMapping("/{studentId}/status")
    public Student changeStudentStatus(@PathVariable String studentId, @RequestParam boolean status) {
        return studentService.changeStudentStatus(studentId, status);
    }

    // Get list of marks for a student
    @GetMapping("/{studentId}/marks")
    public List<String> getListOfMarks(@PathVariable String studentId) {
        return studentService.getListOfMarks(studentId);
    }

    // Get list of attendance records for a student
    @GetMapping("/{studentId}/attendance")
    public List<String> getListOfAttendance(@PathVariable String studentId) {
        return studentService.getListOfAttendance(studentId);
    }
}
