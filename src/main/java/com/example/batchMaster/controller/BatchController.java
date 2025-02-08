package com.example.batchMaster.controller;

import com.example.batchMaster.model.Batch;
import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.Student;
import com.example.batchMaster.model.Subject;
import com.example.batchMaster.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    BatchService batchService;

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
    // 12. Switch a batch status (e.g., active/inactive)
    @PutMapping("/updateBatchStatus")
    public Batch updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }

    // 3. Add a student to a batch
    @PutMapping("/addStudent")
    public Batch addStudent(@RequestParam String batchId, @RequestParam String studentId) {
        return batchService.addStudent(batchId, studentId);
    }

    // 4. Remove a student from a batch
    @PutMapping("/removeStudent")
    public Batch removeStudent(@RequestParam String batchId, @RequestParam String studentId) {
        return batchService.removeStudent(batchId, studentId);
    }

    // 5. Get a list of students in a batch
    @GetMapping("/getListOfStudents")
    public List<Student> getListOfStudents(@RequestParam String batchId) {
        return batchService.getListOfStudents(batchId);
    }

    // 6. Get a list of incomplete subjects in a batch
    @GetMapping("/getListOfAllSubjects")
    public List<Subject> getListOfAllSubjects(@RequestParam String batchId) {
        return batchService.getListOfInCompletedSubjects(batchId);
    }

    // 7. Get a list of completed subjects in a batch
    @GetMapping("/getListOfCompletedSubjects")
    public List<Subject> getListOfCompletedSubjects(@RequestParam String batchId) {
        return batchService.getListOfCompletedSubjects(batchId);
    }



    // 8. Get the current subject being taught in a batch
    @GetMapping("/getListOfCurrentSubjects")
    public List<Subject> getListOfCurrentSubjects(@RequestParam String batchId) {
        return batchService.getListOfCurrentSubjects(batchId);
    }

    // 9. Get a list of online students in a batch
    @GetMapping("/getListOfOnlineStudents")
    public List<Student> getListOfOnlineStudents(@RequestParam String batchId) {
        return batchService.getListOfOnlineStudents(batchId);
    }

    // 10. Get a list of offline students in a batch
    @GetMapping("/getListOfOfflineStudents")
    public List<Student> getListOfOfflineStudents(@RequestParam String batchId) {
        return batchService.getListOfOfflineStudents(batchId);
    }

    // 11. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getListOfTestResults")
    public List<Result> getListOfTestResults(@RequestParam String batchId) {
        return batchService.getListOfTestResults(batchId);
    }
    // 12. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getTestResultsofSubjectofTopic")
    public Result getTestResultsofSubjectofTopic(@RequestParam String batchId,@RequestParam String subject,@RequestParam String topic) {
        return batchService.getTestResultsofSubjectofTopic(batchId,subject,topic);
    }

    // 13. Get test results for a batch (to be implemented with a relevant TestResult model)
    @GetMapping("/getListOfTestResultofSubject")
    public List<Result> getListOfTestResultofSubject(@RequestParam String batchId,@RequestParam String subject) {
        return batchService.getListOfTestResultofSubject(batchId,subject);
    }


}
