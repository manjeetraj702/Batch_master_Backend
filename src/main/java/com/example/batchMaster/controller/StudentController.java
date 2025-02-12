package com.example.batchMaster.controller;

import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;
import com.example.batchMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

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
    @PutMapping("/updateStudent")
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
    public List<Marks> getListOfMarks(@RequestParam String studentId) {
        return studentService.getListOfMarks(studentId);
    }
    @PatchMapping("/{studentId}/batchId")
    Student updateStudentBatchId(String studentId, String batchId) {
        return studentService.updateStudentBatchId(studentId, batchId);
    }

    @PatchMapping("/{student}/remove")
    Student removeStudentFromBatch(String studentId) {
        return studentService.removeStudentFromBatch(studentId);
    }

    @GetMapping("/{batchId}/students")
    List<Student> getStudentsByBatchId(String batchId) {
        return studentService.getStudentsByBatchId(batchId);
    }


    @GetMapping("/{branchId}/students")
    List<Student> getStudentsByBranchId(String branchId) {
        return studentService.getStudentsByBranchId(branchId);
    }

    @GetMapping("/{batchId}/onlineStudents")
    List<Student> getOnlineStudents(String batchId) {
        return studentService.getOnlineStudents(batchId);
    }

    @GetMapping("/{batchId}/offlineStudents")
    List<Student> getOfflineStudents(String batchId) {
        return studentService.getOfflineStudents(batchId);
    }
}
