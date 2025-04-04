package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.Result;
import com.example.batchmaster.model.request.ResultCreateRequest;
import com.example.batchmaster.model.updaterequest.ResultUpdateRequest;
import com.example.batchmaster.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService resultService;

    // Create Result
    @PostMapping("/create")
    public ApiResponse<Result> createResult(@Valid @RequestBody ResultCreateRequest resultCreateRequest) {
        Result createdResult = resultService.createResult(resultCreateRequest);
        return new ApiResponse<>(createdResult, HttpStatus.ACCEPTED);
    }

    // Update Result
    @PutMapping("/update")
    public ApiResponse<Result> updateResult(@Valid @RequestBody ResultUpdateRequest resultUpdateRequest) {
        Result updatedResult = resultService.updateResult(resultUpdateRequest);
        return new ApiResponse<>(updatedResult, HttpStatus.OK);
    }

    // Get Results by Batch ID and Subject ID
    @GetMapping("/getResultsByBatchIdAndSubjectId")
    public ApiResponse<List<Result>> getResultsByBatchIdAndSubjectId(@RequestParam String batchId, @RequestParam String subjectId) {
        List<Result> results = resultService.getResultsByBatchIdAndSubject(batchId, subjectId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Results by Batch ID
    @GetMapping("/getResultByBatchId")
    public ApiResponse<List<Result>> getResultByBatchId(@RequestParam String batchId) {
        List<Result> results = resultService.getResultsByBatchId(batchId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Result by Batch ID, Subject ID, and Topic
    @GetMapping("/getResultByBatchSubjectTopic")
    public ApiResponse<Result> getResultByBatchSubjectTopic(@RequestParam String batchId, @RequestParam String subjectId, @RequestParam String topic) {
        Result result = resultService.getResultByBatchSubjectTopic(batchId, subjectId, topic);
        return new ApiResponse<>(result, HttpStatus.OK);
    }

    // Get Results by Batch ID and Date
    @GetMapping("/getResultsByBatchIdAndDate")
    public ApiResponse<List<Result>> getResultsByBatchIdAndDate(@RequestParam String batchId, @RequestParam Date date) {
        List<Result> results = resultService.getResultsByBatchIdAndDate(batchId, date);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Results by Batch ID Between Dates
    @GetMapping("/getResultsByBatchIdBetweenDates")
    public ApiResponse<List<Result>> getResultsByBatchIdBetweenDates(@RequestParam String batchId, @RequestParam Date startDate, @RequestParam Date endDate) {
        List<Result> results = resultService.getResultsByBatchIdBetweenDates(batchId, startDate, endDate);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Results by Subject
    @GetMapping("/getResultsBySubject")
    public ApiResponse<List<Result>> getResultsBySubject(@RequestParam String subject) {
        List<Result> results = resultService.getResultsBySubject(subject);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Results by Topic
    @GetMapping("/getResultsByTopic")
    public ApiResponse<List<Result>> getResultsByTopic(@RequestParam String topic) {
        List<Result> results = resultService.getResultsByTopic(topic);
        return new ApiResponse<>(results, HttpStatus.OK);
    }
}
