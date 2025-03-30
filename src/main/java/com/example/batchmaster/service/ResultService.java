package com.example.batchmaster.service;

import com.example.batchmaster.model.Result;
import com.example.batchmaster.model.request.ResultCreateRequest;
import com.example.batchmaster.model.updaterequest.ResultUpdateRequest;

import java.util.List;

public interface ResultService {

    Result createResult(ResultCreateRequest resultCreateRequest);

    Result updateResult(ResultUpdateRequest resultUpdateRequest);

    List<Result> getResultsByBatchIdAndSubjectId(String batchId, String subjectId);

    Result getResultsByResultId(String resultId);

    List<Result> getResultByBatchId(String batchId);

    Result getResultByBatchSubjectTopic(String batchId, String subjectId, String topic);
}
