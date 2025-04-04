package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Marks;
import com.example.batchmaster.model.request.MarksCreateRequest;
import com.example.batchmaster.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    private final MarksService marksService;

    @Autowired
    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    // Create Marks
    @PostMapping("/createMarks")
    public ApiResponse<Marks> createMarks(@RequestBody MarksCreateRequest marksCreateRequest) {
        Marks marks = marksService.createMarks(marksCreateRequest);
        return new ApiResponse<>(marks, HttpStatus.CREATED);
    }

    // Update Marks by ID
    @PutMapping("/updateMarks")
    public ApiResponse<Marks> updateMarks(@RequestParam(name = "marksId") String marksId,
                                          @RequestBody Marks updatedMarks) {
        Marks marks = marksService.updateMarks(marksId, updatedMarks);
        return new ApiResponse<>(marks, HttpStatus.OK);
    }

    // Get Marks by Student ID
    @GetMapping("/getMarksByStudentId")
    public ApiResponse<List<Marks>> getMarksByStudentId(@RequestParam(name = "studentId") String studentId) {
        List<Marks> marksList = marksService.getMarksByStudentId(studentId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    // Get Marks by Subject, Topic, and Batch ID
    @GetMapping("/getMarksBySubjectTopicAndBatchId")
    public ApiResponse<List<Marks>> getMarksBySubjectTopicAndBatchId(
            @RequestParam(name = "subject") String subject,
            @RequestParam(name = "topic") String topic,
            @RequestParam(name = "batchId") String batchId) {
        List<Marks> marksList = marksService.getMarksBySubjectTopicAndBatchId(subject, topic, batchId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    // Get Marks by Result ID
    @GetMapping("/getMarksByResultId")
    public ApiResponse<List<Marks>> getMarksByResultId(@RequestParam(name = "resultId") String resultId) {
        List<Marks> marksList = marksService.getMarksByResultId(resultId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    // New Filter Endpoints

    @GetMapping("/getMarksByBatchId")
    public ApiResponse<List<Marks>> getMarksByBatchId(@RequestParam(name = "batchId") String batchId) {
        List<Marks> marksList = marksService.getMarksByBatchId(batchId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdAndSubject")
    public ApiResponse<List<Marks>> getMarksByBatchIdAndSubject(@RequestParam String batchId, @RequestParam String subject) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndSubject(batchId, subject);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdAndTopic")
    public ApiResponse<List<Marks>> getMarksByBatchIdAndTopic(@RequestParam String batchId, @RequestParam String topic) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndTopic(batchId, topic);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdAndDate")
    public ApiResponse<List<Marks>> getMarksByBatchIdAndDate(@RequestParam String batchId, @RequestParam Date date) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndDate(batchId, date);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdAndDateBetween")
    public ApiResponse<List<Marks>> getMarksByBatchIdAndDateBetween(@RequestParam String batchId, @RequestParam Date startDate, @RequestParam Date endDate) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndDateBetween(batchId, startDate, endDate);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdSubjectAndDate")
    public ApiResponse<List<Marks>> getMarksByBatchIdSubjectAndDate(@RequestParam String batchId, @RequestParam String subject, @RequestParam Date date) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndSubjectAndDate(batchId, subject, date);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByBatchIdSubjectTopicAndDate")
    public ApiResponse<List<Marks>> getMarksByBatchIdSubjectTopicAndDate(@RequestParam String batchId, @RequestParam String subject, @RequestParam String topic, @RequestParam Date date) {
        List<Marks> marksList = marksService.getMarksByBatchIdAndSubjectAndTopicAndDate(batchId, subject, topic, date);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }
}
