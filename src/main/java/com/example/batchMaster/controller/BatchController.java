package com.example.batchMaster.controller;

import com.example.batchMaster.model.Batch;
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
    public String createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    // 2. Update an existing batch
    @PutMapping("/updateBatch")
    public String updateBatch(@RequestParam String batchId, @RequestBody Batch updatedBatch) {
        return batchService.updateBatch(batchId, updatedBatch);
    }

    // 3. Add a student to a batch
    @PutMapping("/addStudent")
    public String addStudent(@RequestParam String batchId, @RequestParam String studentId) {
        return batchService.addStudent(batchId, studentId);
    }

    // 4. Remove a student from a batch
    @PutMapping("/removeStudent")
    public String removeStudent(@RequestParam String batchId, @RequestParam String studentId) {
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
    public String getListOfTestResults(@RequestParam String batchId) {
        return batchService.getListOfTestResults(batchId);
    }

    // 12. Switch a batch status (e.g., active/inactive)
    @PutMapping("/batchSwitch")
    public String updateBatchStatus(@RequestParam String batchId) {
        return batchService.updateBatchStatus(batchId);
    }
}
