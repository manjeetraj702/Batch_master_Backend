package com.example.batchMaster.controller;

import com.example.batchMaster.model.*;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    BatchService batchService;

//    Batch
    // 1. Create a new batch
    @PostMapping("/createBatch")
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    // 2. Update an existing batch
    @PutMapping("/updateBatch")
    public Batch updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchId, updatedBatch);
    }
    // 3. Switch a batch status (e.g., active/inactive)
    @PutMapping("/updateBatchStatus")
    public Batch updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }

//    Student
    // 4. Add a student to a batch
    @PutMapping("/addStudent")
    public Batch addStudent(@RequestParam String batchId, @RequestParam String studentId) {
        return batchService.addStudent(batchId, studentId);
    }

    // 5. Remove a student from a batch
    @PutMapping("/removeStudent")
    public Batch removeStudent(@RequestParam String batchId, @RequestParam String studentId) {
        return batchService.removeStudent(batchId, studentId);
    }

    // 6. Get a list of students in a batch
    @GetMapping("/getListOfStudents")
    public List<Student> getListOfStudents(@RequestParam String batchId) {
        return batchService.getListOfStudents(batchId);
    }

    // 7. Get a list of online students in a batch
    @GetMapping("/getListOfOnlineStudents")
    public List<Student> getListOfOnlineStudents(@RequestParam String batchId) {
        return batchService.getListOfOnlineStudents(batchId);
    }

    // 8. Get a list of offline students in a batch
    @GetMapping("/getListOfOfflineStudents")
    public List<Student> getListOfOfflineStudents(@RequestParam String batchId) {
        return batchService.getListOfOfflineStudents(batchId);
    }


//    Subject
    // 9. Get a list of incomplete subjects in a batch
    @GetMapping("/getListOfAllSubjects")
    public List<Subject> getListOfAllSubjects(@RequestParam String batchId) {
        return batchService.getListOfInCompletedSubjects(batchId);
    }

    // 10. Get a list of completed subjects in a batch
    @GetMapping("/getListOfCompletedSubjects")
    public List<Subject> getListOfCompletedSubjects(@RequestParam String batchId) {
        return batchService.getListOfCompletedSubjects(batchId);
    }

    //11.
    @GetMapping("/getCompletedSubjectTopics")
    public Subject getCompletedSubjectTopics(@RequestParam String batchId ,@RequestParam String subject ) {
        return batchService.getCompletedSubjectTopics(batchId,subject);
    }

//todo : incomplete
    // 11. Get the current subject being taught in a batch
    @GetMapping("/getListOfCurrentSubjects")
    public List<Subject> getListOfCurrentSubjects(@RequestParam String batchId) {
        return batchService.getListOfCurrentSubjects(batchId);
    }


// Test Result
    // 12. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getListOfTestResults")
    public List<Result> getListOfTestResults(@RequestParam String batchId) {
        return batchService.getListOfTestResults(batchId);
    }
    // 13. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getTestResultsofSubjectofTopic")
    public Result getTestResultsofSubjectofTopic(@RequestParam String batchId,@RequestParam String subject,@RequestParam String topic) {
        return batchService.getTestResultsofSubjectofTopic(batchId,subject,topic);
    }

    // 14. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getListOfTestResultofSubject")
    public List<Result> getListOfTestResultofSubject(@RequestParam String batchId,@RequestParam String subject) {
        return batchService.getListOfTestResultofSubject(batchId,subject);
    }

//    Attendance


    // Get all student attendance by batch ID
    @GetMapping("/batch/{batchId}")
    public List<Attendance> getAllStudentAttendanceByBatchId(@RequestParam String batchId) {
        return batchService.getAllStudentAttendanceByBatchId(batchId);
    }

    // Get attendance by batch ID and date
    @GetMapping("/batch/{batchId}/date/{date}")
    public List<Attendance> getAttendanceByBatchIdAndDate(@RequestParam String batchId, @RequestParam String date) {
        return batchService.getAttendanceByBatchIdAndDate(batchId, date);
    }



}
