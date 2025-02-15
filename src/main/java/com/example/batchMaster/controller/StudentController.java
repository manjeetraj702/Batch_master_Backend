package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.request.StudentCreateRequest;
import com.example.batchMaster.model.updateRequest.StudentUpdateRequest;
import com.example.batchMaster.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping("/create")
    public ApiResponse<Student> createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest) {
        Student student = studentService.createStudent(studentCreateRequest);
        return new ApiResponse<>(student, HttpStatus.CREATED);
    }

    // Get student details by ID
    @GetMapping("/getStudentDetailsBystudentId")
    public ApiResponse<Student> getStudentDetails(@RequestParam String studentId) {
        Student student = studentService.getStudentDetails(studentId);
        return new ApiResponse<>(student, HttpStatus.OK);
    }

    // Update student details
    @PutMapping("/update")
    public ApiResponse<Student> updateStudent(@Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        Student student = studentService.updateStudent(studentUpdateRequest);
        return new ApiResponse<>(student, HttpStatus.OK);
    }

    // Change student status (active/inactive)
    @PatchMapping("/changeStatus")
    public ApiResponse<Student> changeStudentStatus(@RequestParam String studentId) {
        Student student = studentService.changeStudentStatus(studentId);
        return new ApiResponse<>(student, HttpStatus.OK);
    }

    // Get list of marks for a student
    @GetMapping("/getListOfMarks")
    public ApiResponse<List<Marks>> getListOfMarks(@RequestParam String studentId) {
        List<Marks> marks = studentService.getListOfMarks(studentId);
        return new ApiResponse<>(marks, HttpStatus.OK);
    }

    // Assign a student to a batch
    @PatchMapping("/assignStudentToBatch")
    public ApiResponse<Student> updateStudentBatchId(@RequestParam String studentId, @RequestParam String batchId) {
        Student student = studentService.updateStudentBatchId(studentId, batchId);
        return new ApiResponse<>(student, HttpStatus.OK);
    }

    // Remove student from batch
    @PatchMapping("/removeStudentFromBatch")
    public ApiResponse<Student> removeStudentFromBatch(@RequestParam String studentId) {
        Student student = studentService.removeStudentFromBatch(studentId);
        return new ApiResponse<>(student, HttpStatus.OK);
    }

    // Get students by batch ID
    @GetMapping("/getStudentsByBatchId")
    public ApiResponse<List<Student>> getStudentsByBatchId(@RequestParam String batchId) {
        List<Student> students = studentService.getStudentsByBatchId(batchId);
        return new ApiResponse<>(students, HttpStatus.OK);
    }

    // Get students by branch ID
    @GetMapping("/getStudentsByBranchId")
    public ApiResponse<List<Student>> getStudentsByBranchId(@RequestParam String branchId) {
        List<Student> students = studentService.getStudentsByBranchId(branchId);
        return new ApiResponse<>(students, HttpStatus.OK);
    }

    // Get online students by batch ID
    @GetMapping("/getOnlineStudentsByBatchId")
    public ApiResponse<List<Student>> getOnlineStudents(@RequestParam String batchId) {
        List<Student> students = studentService.getOnlineStudents(batchId);
        return new ApiResponse<>(students, HttpStatus.OK);
    }

    // Get offline students by batch ID
    @GetMapping("/getOfflineStudentsByBatchId")
    public ApiResponse<List<Student>> getOfflineStudents(@RequestParam String batchId) {
        List<Student> students = studentService.getOfflineStudents(batchId);
        return new ApiResponse<>(students, HttpStatus.OK);
    }

    // Get all students
    @GetMapping("/getAllStudents")
    public ApiResponse<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ApiResponse<>(students, HttpStatus.OK);
    }
}
