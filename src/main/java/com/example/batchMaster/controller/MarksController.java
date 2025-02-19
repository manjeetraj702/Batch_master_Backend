package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.Marks;
import com.example.batchMaster.model.request.MarksCreateRequest;
import com.example.batchMaster.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Get Marks by Topic ID, Batch ID & Subject ID
    @GetMapping("/getMarksBySubjectTopicAndBatchId")
    public ApiResponse<List<Marks>> getMarksBySubjectTopicAndBatchId(
            @RequestParam(name = "subject") String subject,
            @RequestParam(name = "topic") String topic,
            @RequestParam(name = "batchId") String batchId) {
        List<Marks> marksList = marksService.getMarksBySubjectTopicAndBatchId(subject, topic, batchId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

    @GetMapping("/getMarksByResultId")
    public ApiResponse<List<Marks>> getMarksByResultId(@RequestParam(name = "resultId") String resultId) {
        List<Marks> marksList = marksService.getMarksByResultId(resultId);
        return new ApiResponse<>(marksList, HttpStatus.OK);
    }

}
