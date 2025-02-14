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
    private StudentService batchStudentService;

    // Create a new student
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        return batchStudentService.createStudent(studentCreateRequest);
    }

    // Get student details by ID
    @GetMapping("/{studentId}")
    public Student getStudentDetails(@PathVariable String studentId) {
        return batchStudentService.getStudentDetails(studentId);
    }

    // Update student details
    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody StudentUpdateRequest studentUpdateRequest) {
        return batchStudentService.updateStudent(studentUpdateRequest);
    }

    // Change student status (active/inactive)
    @PatchMapping("/studentId/status")
    public Student changeStudentStatus(@PathVariable String studentId) {
        return batchStudentService.changeStudentStatus(studentId);
    }


    // Get list of marks for a student
    @GetMapping("/studentId/marks")
    public List<Marks> getListOfMarks(@PathVariable String studentId) {
        return batchStudentService.getListOfMarks(studentId);
    }

    @PatchMapping("/studentId/batchId")
    Student updateStudentBatchId(@PathVariable String studentId, @RequestParam String batchId) {
        return batchStudentService.updateStudentBatchId(studentId, batchId);
    }

    @PatchMapping("/studentId/remove")
    Student removeStudentFromBatch(@RequestParam String studentId) {
        return batchStudentService.removeStudentFromBatch(studentId);
    }

    @GetMapping("/batchId/students")
    List<Student> getStudentsByBatchId(@RequestParam String batchId) {
        return batchStudentService.getStudentsByBatchId(batchId);
    }


    @GetMapping("/branchId/students")
    List<Student> getStudentsByBranchId(@RequestParam String branchId) {
        return batchStudentService.getStudentsByBranchId(branchId);
    }

    @GetMapping("/batchId/onlineStudents")
    List<Student> getOnlineStudents(@RequestParam String batchId) {
        return batchStudentService.getOnlineStudents(batchId);
    }

    @GetMapping("/batchId/offlineStudents")
    List<Student> getOfflineStudents(@RequestParam String batchId) {
        return batchStudentService.getOfflineStudents(batchId);
    }
    @GetMapping("/getAllStudents")
    List<Student> getAllStudents()
    {
        return batchStudentService.getAllStudents();
    }
    
}
