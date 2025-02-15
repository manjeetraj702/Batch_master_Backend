package com.example.batchMaster.controller;

import com.example.batchMaster.base.ApiResponse;
import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.request.ResultCreateRequest;
import com.example.batchMaster.model.updateRequest.ResultUpdateRequest;
import com.example.batchMaster.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<List<Result>> getResultsByBatchIdAndSubjectId(
            @RequestParam String batchId,
            @RequestParam String subjectId) {
        List<Result> results = resultService.getResultsByBatchIdAndSubjectId(batchId, subjectId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Results by Batch ID
    @GetMapping("/getResultByBatchId")
    public ApiResponse<List<Result>> getResultByBatchId(@RequestParam String batchId) {
        List<Result> results = resultService.getResultByBatchId(batchId);
        return new ApiResponse<>(results, HttpStatus.OK);
    }

    // Get Result by Batch ID, Subject ID, and Topic
    @GetMapping("/getResultByBatchSubjectTopic")
    public ApiResponse<Result> getResultByBatchSubjectTopic(
            @RequestParam String batchId,
            @RequestParam String subjectId,
            @RequestParam String topic) {
        Result result = resultService.getResultByBatchSubjectTopic(batchId, subjectId, topic);
        return new ApiResponse<>(result, HttpStatus.OK);
    }
}
