package com.example.batchMaster.controller;

import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.request.ResultCreateRequest;
import com.example.batchMaster.model.updateRequest.ResultUpdateRequest;
import com.example.batchMaster.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@Validated
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/create")
    public Result createResult(@RequestBody ResultCreateRequest resultCreateRequest) {
        return resultService.createResult(resultCreateRequest);
    }

    @PutMapping("/update")
    public Result updateResult(@RequestBody ResultUpdateRequest resultUpdateRequest) {
        return resultService.updateResult(resultUpdateRequest);
    }

    @GetMapping("/byBatch")
    public List<Result> getResultsByBatchId(@RequestParam String batchId, @RequestParam String subjectId) {
        return resultService.getResultsByBatchIdAndSubjectId(batchId, subjectId);
    }

    @GetMapping("/byBatch")
    public List<Result> getResultByBatchId(@RequestParam String batchId) {
        return resultService.getResultByBatchId(batchId);
    }

    @GetMapping("/byBatchSubjectTopic")
    public Result getResultByBatchSubjectTopic(@RequestParam String batchId, @RequestParam String subjectId, @RequestParam String topicId){
        return resultService.getResultByBatchSubjectTopic(batchId, subjectId, topicId);
    }

}