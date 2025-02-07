package com.example.batchMaster.service;

import com.example.batchMaster.model.Result;
import com.example.batchMaster.model.request.ResultCreateRequest;
import com.example.batchMaster.model.updateRequest.ResultUpdateRequest;

import java.util.List;

public interface ResultService {

    Result createResult(ResultCreateRequest resultCreateRequest);

    Result updateResult(ResultUpdateRequest resultUpdateRequest);

    List<Result> getResultsByBatchIdAndSubjectId(String batchId, String subjectId);

    Result getResultsByResultId(String resultId);
}
